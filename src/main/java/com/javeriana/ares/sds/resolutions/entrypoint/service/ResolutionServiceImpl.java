package com.javeriana.ares.sds.resolutions.entrypoint.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.javeriana.ares.sds.resolutions.crosscutting.constants.Constants;
import com.javeriana.ares.sds.resolutions.model.domain.ResolutionDO;
import com.javeriana.ares.sds.resolutions.model.template.ResolutionTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class ResolutionServiceImpl {

    @Value("${resolution.file}")
    private String resolutionFile;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = Constants.TOPIC_NAME)
    public void createResolution(String message) {
        log.info("Message received....");
        JsonObject response = new Gson().fromJson(message, JsonObject.class);
        String statusValue = response.get("estado").getAsString();
        if (statusValue.equalsIgnoreCase(Constants.STATUS_APPROVE) || statusValue.equalsIgnoreCase(Constants.STATUS_DENY)) {
            log.info("Reading message with status " + statusValue);
            JsonObject user = response.getAsJsonObject("creador");
            JsonObject data = response.getAsJsonObject("data");
            boolean status = statusValue.equalsIgnoreCase(Constants.STATUS_APPROVE);
            ResolutionDO resolutionDO = ResolutionDO.builder()
                    .id(response.get("id").getAsString().toUpperCase())
                    .date(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)))
                    .fullName(user.get("name").getAsString().toUpperCase().concat(" ")
                            .concat(user.get("lastName").getAsString().toUpperCase()))
                    .actNumber(data.get("acta").getAsString().toUpperCase())
                    .bookNumber(data.get("libro").getAsString().toUpperCase())
                    .folioNumber(data.get("folio").getAsString().toUpperCase())
                    .job(data.get("profesion").getAsString().toUpperCase())
                    .titleDate(data.get("fecha").getAsString()).yearTitle(data.get("anioTitulo").getAsString())
                    .status(status).statusMessage(status ? Constants.STATUS_APPROVE_MESSAGE : Constants.STATUS_DENY_MESSAGE)
                    .build();
            ResolutionTemplate.createResolution(resolutionFile, resolutionDO);
            String newMessage = message.replace(statusValue, statusValue.toUpperCase() + Constants.STATUS_GENERATED);
            log.info("Sending message...." + newMessage);
            kafkaTemplate.send(Constants.TOPIC_NAME, UUID.randomUUID().toString(), newMessage);
        }
    }

}
