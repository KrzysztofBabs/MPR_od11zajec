package com.example.zajecia2.services;

import com.example.zajecia2.model.Auto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class PDFGenerator {
    public static byte[] generatePdf(Auto auto) throws IOException {
        try (PDDocument document = new PDDocument();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            PDPage page = new PDPage();
            document.addPage(page);


            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Auto Information:");
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("ID: " + auto.getId());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Model: " + auto.getModel());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("RokProdukcji: " + auto.getRokProdukcji());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Identyfiaktor: " + auto.getIdentyfikator());
                contentStream.endText();

            }
            document.save(outputStream);
            return outputStream.toByteArray();
        }
    }}
