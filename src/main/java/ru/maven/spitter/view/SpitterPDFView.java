package ru.maven.spitter.view;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import ru.maven.spitter.DAO.entity.Users;

@Repository(value = "pdfView")
public class SpitterPDFView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map,
            Document document, PdfWriter writer, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        List<Users> listUsers = (List<Users>) map.get("listUsers");

        int[] i = {10,25,25,25,25};
        
        //Создание таблицы
        Table table = new Table(5);
        table.setWidths(i);
        table.setSpacing(0);
        table.setPadding(4);
        table.setAlignment(PATH_VARIABLES);
        table.setWidth(110);
        table.setBorderWidth(1);

        //Добавление строки заголовка
        table.addCell(new Paragraph("ID"));
        table.addCell(new Paragraph("First Name"));
        table.addCell(new Paragraph("Last Name"));
        table.addCell(new Paragraph("Nick Name"));
        table.addCell(new Paragraph("e-mail"));

        //add font
        BaseFont baseFont = BaseFont.createFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(baseFont);
        font.setSize(10);

        //Добавление каждого сообщения
        for (Iterator iter = listUsers.iterator(); iter.hasNext();) {
            Users user = (Users) iter.next();

            table.addCell(new Paragraph(String.valueOf(user.getId()), font));
            table.addCell(new Paragraph(user.getFirstName(), font));
            table.addCell(new Paragraph(user.getLastName(), font));
            table.addCell(new Paragraph(user.getNickName(), font));
            table.addCell(new Paragraph(user.getEmail(), font));
        }

        document.add(new Paragraph("Found Users.", font));

        document.add(table);
    }

}
