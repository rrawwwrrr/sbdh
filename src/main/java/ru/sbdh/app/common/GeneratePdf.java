package ru.sbdh.app.common;

import be.quodlibet.boxable.*;
import be.quodlibet.boxable.line.LineStyle;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbdh.app.models.Otdel;
import ru.sbdh.app.models.User;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.List;


public class GeneratePdf {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneratePdf.class);

    static public ByteArrayInputStream getClerk(List<Otdel> otdels) {
        PDDocument document = new PDDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PDFont formFont = PDType0Font.load(document, new FileInputStream("c:/windows/fonts/times.ttf"), false);
            PDPage page = new PDPage(PDRectangle.A4);
            PDRectangle rect = page.getMediaBox();
            document.addPage(page);
            PDPageContentStream cos = new PDPageContentStream(document, page);
            //Dummy Table
            float margin = 50;
            // starting y position is whole page height subtracted by top and bottom margin
            float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
            // we want table across whole page width (subtracted by left and right margin ofcourse)
            float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

            boolean drawContent = true;
            float yStart = yStartNewPage;
            float bottomMargin = 70;
            float yPosition = 840;

            BaseTable table = new BaseTable(yPosition, yStartNewPage,
                    bottomMargin, tableWidth, margin, document, page, true, drawContent);
            Row<PDPage> headerRow = table.createRow(50);

            // the first parameter is the cell width
            Cell<PDPage> cell = headerRow.createCell(100, "Сотрудники");
            cell.setFont(formFont);
            cell.setFontSize(20);
            // vertical alignment
            cell.setAlign(HorizontalAlignment.CENTER);
            cell.setValign(VerticalAlignment.TOP);
            // border style
            cell.setTopBorderStyle(new LineStyle(Color.BLACK, 10));
            table.addHeaderRow(headerRow);
            for (Otdel otdel : otdels) {
                Row<PDPage> row = table.createRow(20);
                cell = row.createCell(70, otdel.getNameotdel());
                cell.setFont(formFont);
                cell.setFontSize(12);
                cell = row.createCell(30, otdel.getEmail());
                cell.setFontSize(12);
                cell.setFont(formFont);
            }
            /*row = table.createRow(20);
            cell = row.createCell(50, "red right mono");
            cell.setTextColor(Color.RED);
            cell.setFontSize(15);
            cell.setFont(formFont);
            // horizontal alignment
            cell.setAlign(HorizontalAlignment.RIGHT);
            cell.setBottomBorderStyle(new LineStyle(Color.RED, 5));
            cell = row.createCell(50, "green centered italic");
            cell.setTextColor(Color.GREEN);
            cell.setFontSize(15);
            cell.setFont(formFont);
            cell.setAlign(HorizontalAlignment.CENTER);
            cell.setBottomBorderStyle(new LineStyle(Color.GREEN, 5));

            row = table.createRow(20);
            cell = row.createCell(40, "rotated");
            cell.setFontSize(15);
            // rotate the text
            cell.setTextRotated(true);
            cell.setAlign(HorizontalAlignment.RIGHT);
            cell.setValign(VerticalAlignment.MIDDLE);
            // long text that wraps
            cell = row.createCell(30, "long text long text long text long text long text long text long text");
            cell.setFontSize(12);
            // long text that wraps, with more line spacing
            cell = row.createCell(30, "long text long text long text long text long text long text long text");
            cell.setFontSize(12);
            cell.setLineSpacing(2);*/
            table.draw();
            float tableHeight = table.getHeaderAndDataHeight();
            cos.close();
            document.save(out);
            document.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
