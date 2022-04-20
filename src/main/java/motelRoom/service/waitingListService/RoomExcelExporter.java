package motelRoom.service.waitingListService;


import motelRoom.dto.waitingList.WaitingListDetailDto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RoomExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<WaitingListDetailDto> listRooms;

    public RoomExcelExporter(List<WaitingListDetailDto> listRooms) {
        this.listRooms = listRooms;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Rooms");
    }

    private void writeHeaderRow() {
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "id", style);
        createCell(row, 1, "User Id", style);
        createCell(row, 2, "Room Id", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if(value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if(value instanceof  Boolean) {
            cell.setCellValue((Boolean) value);
        } else if(value instanceof  Float) {
            cell.setCellValue((Float) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataRow() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);        style.setFont(font);


        for(WaitingListDetailDto WaitingListDetailDto : listRooms) {
            Row row = sheet.createRow(rowCount++);
            int columnCount =0;

            createCell(row, columnCount++, WaitingListDetailDto.getId().toString(), style);
            createCell(row, columnCount++, WaitingListDetailDto.getUserId().toString(),style);
            createCell(row, columnCount++, WaitingListDetailDto.getRoomId().toString(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDataRow();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
    }
}
