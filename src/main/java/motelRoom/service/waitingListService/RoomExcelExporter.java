package motelRoom.service.waitingListService;

import motelRoom.dto.waitingList.WaitingListBasicDto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
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

    private List<WaitingListBasicDto> listRooms;

    public RoomExcelExporter(List<WaitingListBasicDto> listRooms) {
        this.listRooms = listRooms;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Rooms");
        final XSSFCellStyle cellStyle = workbook.createCellStyle();
    }

    /** create row excel **/
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

    private void writeTitleRow() {
        /** format column **/
        Row row = sheet.createRow(1);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(18);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        sheet.addMergedRegion(new CellRangeAddress(1,1,1,4));

        /** assign value **/
        createCell(row, 1, "Danh sách phòng trọ xem sau", style);
    }

    /** create header row excel **/
    private void writeHeaderRow() {
        /** format column **/
        Row row = sheet.createRow(3);
        CellStyle cellStyle = row.getSheet().getWorkbook().createCellStyle();
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);

        /** assign value **/
        createCell(row, 0, "STT", style);
        sheet.autoSizeColumn(0);
        createCell(row, 1, "Địa chỉ", style);
        sheet.autoSizeColumn(1);
        createCell(row, 2, "Giá(VNĐ)", style);
        sheet.autoSizeColumn(2);
        createCell(row, 3, "Diện tích(m^2)", style);
        sheet.autoSizeColumn(3);
        createCell(row, 4, "Mô tả", style);
        sheet.autoSizeColumn(4);
    }

    /** create data row excel **/
    private void writeDataRow() {
        /** format column **/
        int rowCount = 4;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
        style.setDataFormat(format);

        CellStyle styleCurrent = workbook.createCellStyle();
        styleCurrent.setFont(font);
        styleCurrent.setBorderTop(BorderStyle.THIN);
        styleCurrent.setBorderBottom(BorderStyle.THIN);
        styleCurrent.setBorderLeft(BorderStyle.THIN);
        styleCurrent.setBorderRight(BorderStyle.THIN);
        styleCurrent.setDataFormat((short) 6);
        /** assign value **/
        for(WaitingListBasicDto WaitingListBasicDto : listRooms) {
            Row row = sheet.createRow(rowCount++);
            int columnCount =0;
            createCell(row, columnCount++, "Phòng " + (rowCount-4), style);
            createCell(row, columnCount++, WaitingListBasicDto.getRoomEntity().getStreet()
                            + ", " + WaitingListBasicDto.getRoomEntity().getWardEntity().getWardPrefix()
                            + " " + WaitingListBasicDto.getRoomEntity().getWardEntity().getWardName()
                            + ", " + WaitingListBasicDto.getRoomEntity().getDistrictEntity().getDistrictPrefix()
                            + " " + WaitingListBasicDto.getRoomEntity().getDistrictEntity().getDistrictName()
                            +", " + WaitingListBasicDto.getRoomEntity().getProvinceEntity().getProvinceName()
                    , style);
            createCell(row, columnCount++, WaitingListBasicDto.getRoomEntity().getPrice(), styleCurrent);
            createCell(row, columnCount++, WaitingListBasicDto.getRoomEntity().getCapacity(), style);
            createCell(row, columnCount++, WaitingListBasicDto.getRoomEntity().getDescriptionRoom(), style);
        }
    }

    /** run function **/
    public void export(HttpServletResponse response) throws IOException {
        writeDataRow();
        writeHeaderRow();
        writeTitleRow();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}