package dev.fastfoodapi.service.helper;

import dev.fastfoodapi.model.LoaiMatHang;
import dev.fastfoodapi.model.MatHang;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelperMatHang {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "MatHang";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<MatHang> excelToTutorials(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<MatHang> tutorials = new ArrayList<MatHang>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0 || rowNumber == 1) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                MatHang obj = new MatHang();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            obj.setMaMH((long) currentCell.getNumericCellValue());
                            break;

                        case 1:
                            obj.setHinhAnh(currentCell.getStringCellValue());
                            break;

                        case 2:
                            obj.setTenMH(currentCell.getStringCellValue());
                            break;

                        case 3:
                            obj.setMoTa(currentCell.getStringCellValue());
                            break;

                        case 4:
                            obj.setDonViTinh(currentCell.getStringCellValue());
                            break;

                        case 5:
                            obj.setDonGia(currentCell.getNumericCellValue());
                            break;

                        case 6:
                            obj.setLoaiMatHang(new LoaiMatHang().builder().maLMH((long) currentCell.getNumericCellValue()).build());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                tutorials.add(obj);
            }

            workbook.close();

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("Lỗi phân tích file Excel: " + e.getMessage());
        }
    }

}
