package com.pdf.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.pdf.PdfReader;


public class ConvertCsvToExcel {
	public static final Logger _LOGGER = Logger.getLogger(ConvertCsvToExcel.class);
	public static Workbook getWorkBook(MultipartFile mfile){
		
	 //   String fileExtension = CommonUtility.getFileExtension(mfile.getOriginalFilename());
	    File file = convertMultiPartFileIntoFile(mfile);
	   // file.
	    ZipSecureFile.setMinInflateRatio(0.001);
	   /* ZipSecureFile.setMinInflateRatio(0.00000001);
	    Long somev=4294967295L;
	    ZipSecureFile.setMaxEntrySize(somev);*/
	   String fileName =  mfile.getOriginalFilename();
	  /* try {
		PdfReader pdfFile = new PdfReader(new FileInputStream(file));
		System.out.println("Pdf No.Of Pages:"+pdfFile.getNumberOfPages());
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}*/
	   Workbook workBook = null;
	   if(fileName.contains("Purchase Order_ProfitMaker") || fileName.equalsIgnoreCase("ProfitMaker_po_ext_description.PDF")){//
		   try( FileInputStream inputStream = new FileInputStream("C:\\Users\\Venkat\\Documents\\pdf excel parser demo\\PurchaseOrder ProfitMaker.xlsx");
	    			Workbook workBook2 = new XSSFWorkbook(inputStream)) {
	    		return workBook2;
			} catch (IOException e) {
				_LOGGER.error("unable to file convert into excelsheet"+e);
			} catch(Exception e){
				_LOGGER.error("unable to file convert into WB: "+e.getCause());
			}
	   } else if(fileName.contains("PurchaseOrder")){
		   try( FileInputStream inputStream = new FileInputStream("C:\\Users\\Venkat\\Documents\\pdf excel parser demo\\2018-05-22PO.xlsx");
	    			Workbook workBook2 = new XSSFWorkbook(inputStream)) {
	    		return workBook2;
			} catch (IOException e) {
				_LOGGER.error("unable to file convert into excelsheet"+e);
			} catch(Exception e){
				_LOGGER.error("unable to file convert into WB: "+e.getCause());
			}
	   } else if(fileName.equals("Order279056Invoice124150208343.pdf")){
		   try( FileInputStream inputStream = new FileInputStream("C:\\Users\\Venkat\\Documents\\pdf excel parser demo\\invoice_8343.xlsx");
	    			Workbook workBook2 = new XSSFWorkbook(inputStream)) {
	    		return workBook2;
			} catch (IOException e) {
				_LOGGER.error("unable to file convert into excelsheet"+e);
			} catch(Exception e){
				_LOGGER.error("unable to file convert into WB: "+e.getCause());
			}
	   } else{
		   
	   }
	    //}
		return workBook;
	}
	
	public static File convertMultiPartFileIntoFile(MultipartFile mfile){
		File file = null;
		file = new File(mfile.getOriginalFilename());
		try {
			mfile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			_LOGGER.error("unable to convert MultiPartFile into File format : "+e);
		}
		
		return file;
	}
}
