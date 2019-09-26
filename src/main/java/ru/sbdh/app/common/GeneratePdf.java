package ru.sbdh.app.common;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


public class GeneratePdf {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneratePdf.class);

    static public ByteArrayInputStream getClerk() {
        PDDocument document = new PDDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PDPage page = new PDPage();
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.COURIER, 12);
            contentStream.beginText();
            contentStream.showText("Hello World");
            contentStream.endText();
            contentStream.close();
            document.save(out);
            document.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
