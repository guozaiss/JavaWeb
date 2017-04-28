package com.example.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guo on 2017/4/28.
 */
@Component
public class ExcelUtils {
    @Value("${emails_address}")
    private String emailAddress;
    public List<String> readEmailAddress() {
        return read(emailAddress);
    }

    public List<String> read(String path) {
        try {
            if (path.endsWith(".xls")) {
                return readXls(path);
            } else if (path.endsWith(".xlsx")) {
                return readXlsX(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> readXls(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < hssfWorkbook.getNumberOfSheets(); i++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(i);
            if (hssfSheet == null) {
                continue;
            }
            for (int j = 0; j <= hssfSheet.getLastRowNum(); j++) {
                HSSFRow hssfRow = hssfSheet.getRow(j);
                if (hssfRow == null) {
                    continue;
                }
                short firstCellNum = hssfRow.getFirstCellNum();
                short lastCellNum = hssfRow.getLastCellNum();
                for (int k = firstCellNum; k < lastCellNum; k++) {
                    HSSFCell cell = hssfRow.getCell(k);
                    if (cell == null) {
                        continue;
                    }
                    strings.add(cell.getStringCellValue());
                }

            }
        }
        return strings;
    }

    private List<String> readXlsX(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < hssfWorkbook.getNumberOfSheets(); i++) {
            XSSFSheet xssfSheet = hssfWorkbook.getSheetAt(i);
            if (xssfSheet == null) {
                continue;
            }
            for (int j = 0; j <= xssfSheet.getLastRowNum(); j++) {
                XSSFRow xssfRow = xssfSheet.getRow(j);
                if (xssfRow == null) {
                    continue;
                }
                short firstCellNum = xssfRow.getFirstCellNum();
                short lastCellNum = xssfRow.getLastCellNum();
                for (int k = firstCellNum; k < lastCellNum; k++) {
                    XSSFCell cell = xssfRow.getCell(k);
                    if (cell == null) {
                        continue;
                    }
                    strings.add(cell.getStringCellValue());
                }

            }
        }
        return strings;
    }
}