package motelRoom.controller;

import motelRoom.dto.room.RoomDetailDto;
import motelRoom.dto.user.UserDetailDto;
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
import java.util.UUID;

public class RoomExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<RoomDetailDto> listRooms;

    public RoomExcelExporter(List<RoomDetailDto> listRooms) {
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

        createCell(row, 0, "Room Id", style);
        createCell(row, 1, "User Id", style);
        createCell(row, 2, "Province Id", style);
        createCell(row, 3, "District Id", style);
        createCell(row, 4, "Ward Id", style);
        createCell(row, 5, "Street", style);
        createCell(row, 6, "Price", style);
        createCell(row, 7, "Capacity", style);
        createCell(row, 8, "Description Room", style);
        createCell(row, 9, "Status Room", style);
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
        font.setFontHeight(14);
        style.setFont(font);

        for(RoomDetailDto roomDetailDto : listRooms) {
            Row row = sheet.createRow(rowCount++);
            int columnCount =0;

            createCell(row, columnCount++, roomDetailDto.getRoomId().toString(), style);
            createCell(row, columnCount++, roomDetailDto.getUserId().toString(),style);
            createCell(row, columnCount++, roomDetailDto.getProvinceId(), style);
            createCell(row, columnCount++, roomDetailDto.getDistrictId(), style);
            createCell(row, columnCount++, roomDetailDto.getWardId(), style);
            createCell(row, columnCount++, roomDetailDto.getStreet(), style);
            createCell(row, columnCount++, roomDetailDto.getPrice(), style);
            createCell(row, columnCount++, roomDetailDto.getCapacity(), style);
            createCell(row, columnCount++, roomDetailDto.getDescriptionRoom(), style);
            createCell(row, columnCount++, roomDetailDto.getStatusRoom(), style);
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
