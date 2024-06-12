package com.example.demo.utils;

import com.example.demo.entity.People;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ExcelUtil {

    public static List<People> parseExcel(MultipartFile file, String ruleId) throws IOException {
        List<People> peopleList = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) { // Skip header row
                continue;
            }
            People person = new People();
            person.setPeopleListId(ruleId);

            // Read peopleName
            Cell nameCell = row.getCell(0);
            if (nameCell != null) {
                if (nameCell.getCellType() == CellType.STRING) {
                    person.setPeopleName(nameCell.getStringCellValue());
                } else if (nameCell.getCellType() == CellType.NUMERIC) {
                    person.setPeopleName(String.valueOf(nameCell.getNumericCellValue()));
                }
            }

            // Read peoplePhoneNumber
            Cell phoneNumberCell = row.getCell(1);
            if (phoneNumberCell != null) {
                if (phoneNumberCell.getCellType() == CellType.STRING) {
                    person.setPeoplePhoneNumber(phoneNumberCell.getStringCellValue());
                } else if (phoneNumberCell.getCellType() == CellType.NUMERIC) {
                    person.setPeoplePhoneNumber(String.valueOf(phoneNumberCell.getNumericCellValue()));
                }
            }

            person.setPeoplePrize(""); // Initialize as empty string
            peopleList.add(person);
            System.out.println(person.getPeopleName());

        }
        workbook.close();

        return peopleList;
    }
}