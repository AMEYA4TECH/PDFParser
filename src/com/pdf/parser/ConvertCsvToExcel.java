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


public class ConvertCsvToExcel {
	public static final Logger _LOGGER = Logger.getLogger(ConvertCsvToExcel.class);
	public static Workbook getWorkBook(MultipartFile mfile){
		
	 //   String fileExtension = CommonUtility.getFileExtension(mfile.getOriginalFilename());
	    File file = convertMultiPartFileIntoFile(mfile);
	    ZipSecureFile.setMinInflateRatio(0.001);
	   /* ZipSecureFile.setMinInflateRatio(0.00000001);
	    Long somev=4294967295L;
	    ZipSecureFile.setMaxEntrySize(somev);*/
	    Workbook workBook = null;
	   
	    	try( FileInputStream inputStream = new FileInputStream(file);
	    			Workbook workBook2 = new XSSFWorkbook(inputStream)) {
	    		return workBook2;
			} catch (IOException e) {
				_LOGGER.error("unable to file convert into excelsheet"+e);
			} catch(Exception e){
				_LOGGER.error("unable to file convert into WB: "+e.getCause());
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