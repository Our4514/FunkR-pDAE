package com.xf.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {

	public static void exportExcel(List<String> headers,List<List<String>> list, OutputStream  os) {  
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
        int count = 0;
        //������ͷ  
        for (int i = 0; i < headers.size(); i++) {  
            //������������ı�ͷ�ĸ���  
            cell = row.createCell(i+1);  
            //��ͷ��ֵ���Ǵ��������ֵ  
            cell.setCellValue(headers.get(i));
            cell.setCellStyle(cellStyle);
  
        }  
        
        // �õ����м�¼ �У���  
        List<String> record = null;  
  
        if (list != null) {  
            //��ȡ���еļ�¼ �ж�������¼�ʹ���������  
            for (int i = 0; i < list.size(); i++) {  
                row = xssfSheet.createRow(++count);  
                // �õ����е��� һ��record�ʹ��� һ��  
                record = list.get(i);  
                //�������еļ�¼����֮�ϣ�������������ı�ͷ,�ٴ���N��  
                for (int j = 0; j< record.size();j++) {
                    cell = row.createCell(j);  
                    //��ÿһ�еļ�¼�ٴ���ӵ���ͷ���� ���Ϊ�վ�Ϊ "" �����Ϊֵ  
                    cell.setCellValue(record.get(j)==null?"":record.get(j).toString());
                    cell.setCellStyle(cellStyle);
                }  
            }  
        }
        try {  
        	// FileOutputStream fileOutputStreane = new FileOutputStream(file);
            xssfWorkbook.write(os);  
            os.flush();  
            os.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
	
	
	
	public static void exportExcel2(Set<String> headers,Set<String> lie,Map<String, String> content, OutputStream  os) {  
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
        int count = 0;
        //������ͷ 
        int i = 0;
        for( Iterator   it = headers.iterator();  it.hasNext(); )   {   
        	 //������������ı�ͷ�ĸ���  
            cell = row.createCell(i+1);  
            //��ͷ��ֵ���Ǵ��������ֵ  
            cell.setCellValue(it.next().toString());
            cell.setCellStyle(cellStyle);
            i++;
        }   
        // �õ����м�¼ �У���  
        List<String> record = null;  
  
        if (lie != null) {  
            //��ȡ���еļ�¼ �ж�������¼�ʹ���������  
        	for( Iterator   it = lie.iterator();  it.hasNext(); )   {  
        		 row = xssfSheet.createRow(++count); 
        		 int j = 0;
        		 String followId = it.next().toString();
        		 for( Iterator   it2 = headers.iterator();  it2.hasNext(); )   {  
        			 cell = row.createCell(j);  
        			 if(j == 0) {
        				 cell.setCellValue(followId);
        			 }else {
        				 String contentCell = content.get(followId+"_"+it2.next().toString());
            			 if(contentCell == null) {
            				 contentCell = "0";
            			 }
            			 cell.setCellValue(contentCell);
        			 }
        			 cell.setCellStyle(cellStyle);
        			 j++;
        		 }
        	}
        }
        try {  
        	// FileOutputStream fileOutputStreane = new FileOutputStream(file);
            xssfWorkbook.write(os);  
            os.flush();  
            os.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
	
	public static void exportExcel2(List<String> headers,List<String> lie,Map<String, String> content, OutputStream  os) {  
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
        int count = 0;
        //������ͷ 
        int i = 0;
        for( Iterator   it = headers.iterator();  it.hasNext(); )   {   
        	 //������������ı�ͷ�ĸ���  
            cell = row.createCell(i+1);  
            //��ͷ��ֵ���Ǵ��������ֵ  
            cell.setCellValue(it.next().toString());
            cell.setCellStyle(cellStyle);
            i++;
        }   
        // �õ����м�¼ �У���  
        List<String> record = null;  
  
        if (lie != null) {  
            //��ȡ���еļ�¼ �ж�������¼�ʹ���������  
        	for( Iterator   it = lie.iterator();  it.hasNext(); )   {  
        		 row = xssfSheet.createRow(++count); 
        		 int j = 0;
        		 String followId = it.next().toString();
        		 for( Iterator   it2 = headers.iterator();  it2.hasNext(); )   {  
        			 cell = row.createCell(j);  
        			 if(j == 0) {
        				 cell.setCellValue(followId);
        			 }else {
        				 String contentCell = content.get(followId+"_"+it2.next().toString());
            			 if(contentCell == null) {
            				 contentCell = "0";
            			 }
            			 cell.setCellValue(contentCell);
        			 }
        			 cell.setCellStyle(cellStyle);
        			 j++;
        		 }
        	}
        }
        try {  
        	// FileOutputStream fileOutputStreane = new FileOutputStream(file);
            xssfWorkbook.write(os);  
            os.flush();  
            os.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
	
	 public static Integer[][] getArray2(List<List<Integer>> list){  
		 	Integer[][] ps = new Integer[list.size()][];  
	        for (int i = 0; i < list.size(); i++) {  
	            ps[i] = list.get(i).toArray(new Integer[list.get(i).size()]);  
	        }  
	        return ps;  
	    }  
	 
	 public static Object[][] getObjectArray2(List<List<Object>> list){  
		 Object[][] ps = new Object[list.size()][];  
	        for (int i = 0; i < list.size(); i++) {  
	            ps[i] = list.get(i).toArray(new Object[list.get(i).size()]);  
	        }  
	        return ps;  
	    }  
	 
	 
	 /**
	  * ��ȡExcel2003-2007�汾����
	  * @author fangcv
	  * @throws IOException
	  */
	 public List<Record> readXls(String path) throws IOException {
	     InputStream is = new FileInputStream(path);
	     HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
	     Record record = null;
	     List<Record> list = new ArrayList<Record>();
	     // Read the Sheet
	     for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
	         HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
	         if (hssfSheet == null) {
	             continue;
	         }
	         // Read the Row
	         for (int rowNum = 3; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
	             HSSFRow hssfRow = hssfSheet.getRow(rowNum);
	             if (hssfRow != null) {
	                 HSSFCell tickNo = hssfRow.getCell(0);
	                 HSSFCell name = hssfRow.getCell(1);
	                 HSSFCell age = hssfRow.getCell(2);
	                 HSSFCell score = hssfRow.getCell(3);
	                 list.add(record);
	             }
	         }
	     }
	     return list;
	 }
	 
	 /**
	  * ��ȡExcel2010�汾����
	  * @author fangcv
	  * @throws IOException
	  */
	 public List<Record> readXlsx(String path) throws IOException {
	     InputStream is = new FileInputStream(path);
	     XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
	     Record record = null;
	     List<Record> list = new ArrayList<Record>();
	     // Read the Sheet
	     for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
	         XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
	         if (xssfSheet == null) {
	             continue;
	         }
	         // Read the Row
	         for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
	             XSSFRow xssfRow = xssfSheet.getRow(rowNum);
	             if (xssfRow != null) {
	                 XSSFCell tickNo = xssfRow.getCell(0);
	                 XSSFCell name = xssfRow.getCell(1);
	                 XSSFCell age = xssfRow.getCell(2);
	                 XSSFCell score = xssfRow.getCell(3);
	                 list.add(record);
	             }
	         }
	     }
	     return list;
	 }
	 
	 /**
	  * ��ȡExcel2010�汾��Ԫ������
	  * @author fangcv
	  * @param xssfRow
	  * @return
	  */
	 private String getValue(XSSFCell xssfRow) {
         if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
             return String.valueOf(xssfRow.getBooleanCellValue());
         } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
             return String.valueOf(xssfRow.getNumericCellValue());
         } else {
             return String.valueOf(xssfRow.getStringCellValue());
         }
     }
	 
	 /**
	  * ��ȡExcel2003-2007�汾��Ԫ������
	  * @author fangcv
	  * @param hssfCell
	  * @return
	  */
	 private String getValue(HSSFCell hssfCell) {
         if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
             return String.valueOf(hssfCell.getBooleanCellValue());
         } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
             return String.valueOf(hssfCell.getNumericCellValue());
         } else {
             return String.valueOf(hssfCell.getStringCellValue());
         }
     }
}
