package ru.kpfu.itis.NeilAlishev.sem1.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ru.kpfu.itis.NeilAlishev.sem1.models.Mark;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public class PDFBuilder extends AbstractITextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<Mark> listMarks = (List<Mark>) model.get("listMarks");

        doc.add(new Paragraph("Ваши оценки"));

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{3.0f, 2.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(BaseFont.IDENTITY_H);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);

        // write table header
        cell.setPhrase(new Phrase("Предмет", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Учитель", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Оценка", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Дата", font));
        table.addCell(cell);

        // write table row data
        for (Mark mark : listMarks) {
            table.addCell(mark.getSubject());
            table.addCell(mark.getTeacher().getFullName());
            table.addCell(mark.getScore().toString());
            table.addCell(mark.getCreatedAt().toString());
        }
        doc.add(table);

    }

}