package com.javeriana.ares.sds.resolutions.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResolutionDO {

    private String id;
    private Date date;
    private String fullName;
    private String job;
    private String titleDate;
    private String actNumber;
    private String bookNumber;
    private String folioNumber;
    private String yearTitle;
    private boolean status;
    private String statusMessage;




}
