package com.xf.modelTrain;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xf.util.Util;

public class multiMatrix {
//������˷���
	public static Double[][] multiMetrixAandB(Double metrixA[][] , Double metrixB[][]){
		Double result[][] = new Double[metrixA.length][metrixB[0].length];
		int x,i,j=0;
		Double tmp=0.0;
		for(i =0;i<metrixA.length;i++){
			for(j = 0;j<metrixB[0].length;j++){
				for( x=0;x<metrixB.length;x++) {
					tmp += metrixA[i][x] * metrixB[x][j];//����AB��a_ij��ֵ���ھ���A��i�к;���B��j�еĳ˻�֮��
				} 
				 result[i][j] = tmp;
				 tmp = 0.0; //�м������ÿ��ʹ�ú󶼵�����
			}
		}
		//��ӡ�����ľ���
		System.out.println("\n"+"����A*B��ֵΪ��");
		for( i=0;i<result.length;i++){	
			for(j=0;j<result[i].length;j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.print("\n");
		}
		return result;
	}
	
	public static Double[][] processData(String filePath) {
		try {
			  System.out.println("��ȡ�������ݿ�ʼ....");
			  InputStream is = new FileInputStream(filePath);
			     XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			     // Read the Sheet
			     for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			         XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			         if (xssfSheet == null) {
			             continue;
			         }
			         Double metrixA[][] = new Double [xssfSheet.getLastRowNum()+1][];//NEWһ�����飬�������A
			         // Read the Row
			         for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
			             XSSFRow xssfRow = xssfSheet.getRow(rowNum);
			             if (xssfRow != null) {
			            	 int cellNum = xssfRow.getPhysicalNumberOfCells();
			            	 metrixA[rowNum] = new Double [cellNum];
			            	 for(int j =0;j<cellNum;j++) {
			     				metrixA[rowNum][j] = Double.parseDouble(getValue(xssfRow.getCell(j)));
			     			}
			             }
			         }
			         //��ӡ����
			         System.out.println("��"+filePath+"�л�ȡ�ľ����ֵΪ��");
			 		for(int i=0;i<metrixA.length;i++){	
			 			for(int j=0;j<metrixA[i].length;j++){
			 				System.out.print(metrixA[i][j] + " ");
			 			}
			 			System.out.print("\n");
			 		}
			 		return metrixA;
			     }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String getValue(XSSFCell xssfRow) {
	      if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
	          return String.valueOf(xssfRow.getBooleanCellValue());
	      } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
	          return String.valueOf(xssfRow.getNumericCellValue());
	      } else {
	          return String.valueOf(xssfRow.getStringCellValue());
	      }
	  }
	
	public static void main(String args[]){
		try {
			System.out.println("���ݴ���ʼ........");
			Double metrixA[][] = processData("F:\\project_vactor.xlsx");
			Double metrixB[][] = processData("F:\\developer_vactor.xlsx");
			if(metrixA == null || metrixB == null) {
				System.out.println("��ȡ����ʧ�ܣ�");
				return;
			}
			int Arow = metrixA.length;
			int Bcolumn = metrixB[0].length;
			if(Arow != Bcolumn) {
				JOptionPane.showMessageDialog(null,"����A(m*n)�;���B(u*v)�����Ҫ���� n==u!��A(m*n)-B(n*k)","��ܰ��ʾ",JOptionPane.INFORMATION_MESSAGE);
			}
			Double result[][]  = multiMetrixAandB(metrixA,metrixB);
			
			File mainFile_excel = new File("f:/multiMatrix.xlsx");
			 OutputStream out = new FileOutputStream(mainFile_excel);
			 Util.exportExcel(result, out);
			 System.out.println("���ݴ������........");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	public static void main1(String args[]){
//		Scanner input = new Scanner(System.in);
//		System.out.print("���������A��������������");
//		int row = input.nextInt();
//		int column = input.nextInt();
//		System.out.println("������"+row +"��" + column+"�еľ���A��");
//		int metrixA[][] = new int [row][column];//NEWһ�����飬�������A
//		for(int i =0;i<row;i++) {
//			for(int j =0;j<column;j++) {
//				metrixA[i][j] = input.nextInt();
//			}
//		}
//		System.out.print("���������B��������������");
//		int rowB = input.nextInt();
//		if(rowB != column) {
//			JOptionPane.showMessageDialog(null,"����A(m*n)�;���B(u*v)�����Ҫ���� n==u!��A(m*n)-B(n*k)","��ܰ��ʾ",JOptionPane.INFORMATION_MESSAGE);
//		}
//		int columnB = input.nextInt();
//		System.out.println("������"+rowB +"��" + columnB+"�еľ���B��");
//		int metrixB[][] = new int [rowB][columnB];//NEWһ�����飬�������B
//		for(int i =0;i<rowB;i++) {
//			for(int j =0;j<columnB;j++) {
//				metrixB[i][j] = input.nextInt();
//			}
//		}
//		multiMetrixAandB(metrixA,metrixB);
//	}
}
