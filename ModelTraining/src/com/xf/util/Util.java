package com.xf.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {
	public static void exportExcel(Double[][] content, OutputStream  os) {  
        // ����������  
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();  
        // �����������еĹ�����  ��sheet:һ�ű�ļ��  ��
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet0");
        
        //������ʽ
        xssfSheet.setDefaultColumnWidth(256 * 2 * 8);//����ȱʡ�п�
        XSSFCellStyle cellStyle=xssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);
        cellStyle.setFillBackgroundColor(HSSFColor.LIGHT_YELLOW.index);
        //����ָ���е��п�256 * 50����д������Ϊwidth������λ�ǵ����ַ���256��֮һ  
        xssfSheet.setColumnWidth(0, 256 * 2 * 15);//15������
        xssfSheet.setColumnWidth(2, 256 * 2 * 9);
        xssfSheet.setColumnWidth(3, 256 * 2 * 9);
        xssfSheet.setColumnWidth(4, 256 * 2 * 25);
        xssfSheet.setColumnWidth(5, 256 * 2 * 10);
        
        // ������һ��  ����ͷ��
        XSSFRow row = xssfSheet.createRow(0);  
        // ������Ԫ�����ñ�ͷ ������  
        XSSFCell cell = null;  
  
        //��ȡ���еļ�¼ �ж�������¼�ʹ���������  
        for (int i = 0; i < content.length; i++) {  
            row = xssfSheet.createRow(i);  
            //�������еļ�¼����֮�ϣ�������������ı�ͷ,�ٴ���N��  
            for (int j = 0; j< content[i].length;j++) {
                cell = row.createCell(j);  
                //��ÿһ�еļ�¼�ٴ���ӵ���ͷ���� ���Ϊ�վ�Ϊ "" �����Ϊֵ  
                cell.setCellValue(content[i][j]);
                cell.setCellStyle(cellStyle);
            }  
        }  
        try {  
            xssfWorkbook.write(os);  
            os.flush();  
            os.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}
