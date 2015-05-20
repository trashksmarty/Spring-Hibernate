package ru.maven.spitter.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.stereotype.Repository;
import ru.maven.spitter.DAO.entity.Users;

@Repository(value = "excelView")
public class SpitterExcelView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // получить модель данных, которая передается в Spring контроллер
        List<Users> listUsers = (List<Users>) model.get("listUsers");

        // создать новый лист Excel
        HSSFSheet sheet = workbook.createSheet("Spitter Users");
        sheet.setDefaultColumnWidth(30);

        // создать стиль для ячеек заголовков
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        // создать строку заголовка
        HSSFRow header = sheet.createRow(0);

        header.createCell(0).setCellValue("ID");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("First Name");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("LastName");
        header.getCell(2).setCellStyle(style);

        header.createCell(3).setCellValue("Nick Name");
        header.getCell(3).setCellStyle(style);

        header.createCell(4).setCellValue("E-mail");
        header.getCell(4).setCellStyle(style);

        // создания строк данных
        int rowCount = 1;

        for (Users aUser : listUsers) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(aUser.getId());
            aRow.createCell(1).setCellValue(aUser.getFirstName());
            aRow.createCell(2).setCellValue(aUser.getLastName());
            aRow.createCell(3).setCellValue(aUser.getNickName());
            aRow.createCell(4).setCellValue(aUser.getEmail());
        }
    }

}
