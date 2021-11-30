package com.javeriana.ares.sds.resolutions.model.template;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.javeriana.ares.sds.resolutions.crosscutting.constants.Constants;
import com.javeriana.ares.sds.resolutions.model.domain.ResolutionDO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ResolutionTemplate {

    private static Paragraph paragraph;

    private static Font bold = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD);

    public static void createResolution(String resolutionFile, ResolutionDO resolutionDO) {
        try {
            Chunk fullName = new Chunk(resolutionDO.getFullName(), bold);
            Chunk statusMessage = new Chunk(resolutionDO.getStatusMessage(), bold);

            Document document = new Document(PageSize.A4, 40f, 40f, 40f, 40f);
            PdfWriter.getInstance(document, new FileOutputStream(resolutionFile
                    .replace("{id}", resolutionDO.getId())));
            document.open();
            paragraph = new Paragraph(Constants.RESOLUTION_TITLE.replace("{id}", resolutionDO.getId())
                    .replace("{date}", Constants.FORMAT_DATE.format(resolutionDO.getDate())));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);

            paragraph = new Paragraph(Constants.RESOLUTION_TITLE_2, bold);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);

            paragraph = new Paragraph(Constants.RESOLUTION_PARAGRAPH_1);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);

            paragraph = new Paragraph(Constants.RESOLUTION_PARAGRAPH_2);
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);

            paragraph = new Paragraph(Constants.RESOLUTION_TITLE_3, bold);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);

            paragraph = new Paragraph(Constants.RESOLUTION_PARAGRAPH_3_1);
            paragraph.add(fullName);
            paragraph.add(new Paragraph(Constants.RESOLUTION_PARAGRAPH_3_2
                    .replace("{job}", resolutionDO.getJob()).replace("{titleDate}", resolutionDO.getTitleDate())
                    .replace("{actNumber}", resolutionDO.getActNumber()).replace("{bookNumber}", resolutionDO.getBookNumber())
                    .replace("{folioNumber}", resolutionDO.getFolioNumber()).replace("{yearTitle}", resolutionDO.getYearTitle())));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);

            paragraph = new Paragraph(Constants.RESOLUTION_TITLE_4);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);

            paragraph = new Paragraph(Constants.RESOLUTION_ARTICLE_1_1);
            paragraph.add(statusMessage);
            paragraph.add(new Chunk(Constants.RESOLUTION_ARTICLE_1_2));
            paragraph.add(fullName);
            paragraph.add(new Chunk(Constants.RESOLUTION_ARTICLE_1_3
                    .replace("{job}", resolutionDO.getJob())));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);

            if (resolutionDO.isStatus()) {
                paragraph = new Paragraph(Constants.ARTICLE_2);
                paragraph.add(fullName);
                paragraph.add(new Chunk(Constants.RESOLUTION_ARTICLE_2));
                paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(paragraph);
                document.add(Chunk.NEWLINE);
            }

            paragraph = new Paragraph(Constants.RESOLUTION_ARTICLE_3_1
                    .replace("{article}", resolutionDO.isStatus() ? Constants.ARTICLE_3 : Constants.ARTICLE_2));
            paragraph.add(fullName);
            paragraph.add(new Chunk(Constants.RESOLUTION_ARTICLE_3_2));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);

            paragraph = new Paragraph(Constants.RESOLUTION_PARAGRAPH_4.replace("{date}",
                    Constants.FORMAT_DATE.format(resolutionDO.getDate())));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            if (!resolutionDO.isStatus()) {
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
            }

            paragraph = new Paragraph(new Phrase(20f, Constants.SIGN,
                    FontFactory.getFont(FontFactory.TIMES_ITALIC, 40f)));
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph);

            paragraph = new Paragraph(new Phrase(20f, Constants.SIGN_NAME,
                    FontFactory.getFont(FontFactory.TIMES_ROMAN, 10f)));
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph);

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
