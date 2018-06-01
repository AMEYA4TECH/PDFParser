package com.pdf.parser;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping({ "/", "/uploadFile.htm" })
public class FileUpload {
	private static Logger _LOGGER = Logger.getLogger(Class.class);
	@RequestMapping(method = RequestMethod.GET)
	public String welcomePage(Map<String, Object> model) {
		
		return "upload";
		/*FtpLoginBean ftpLogin = new FtpLoginBean(); //uncommented code while using ftp
		model.put("ftpLoginBean", ftpLogin);
		return "ftpLogin";*/ 
		}
	@RequestMapping(value="/parseFile",method=RequestMethod.POST)  
	public ModelAndView upload(@RequestParam CommonsMultipartFile file,HttpSession session){ 
		String filename="";
		LinkedHashMap<String,String> valueMap=new LinkedHashMap<String, String>();
		Mapclas contactForm = null;
		try{  
	        String path=session.getServletContext().getRealPath("/");  
	        filename=file.getOriginalFilename();  
	          
	        System.out.println(path+" "+filename);  
	        Workbook workbook=  ConvertCsvToExcel.getWorkBook(file);
	        if(filename.trim().equals("Order279056Invoice124150208343.pdf")){
	        	valueMap=ExcelMapping.readExcel(workbook);	
	        }else{
	        	valueMap=PurOrdParser.readExcel(workbook);
	        }
	        
	        
	       /* try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path+"/"+filename));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          */
	         contactForm = new Mapclas();
			contactForm.setContactMap(valueMap);
			
			//return new ModelAndView("add_contact" , "contactForm", contactForm);
	        }catch(Exception e){
	        	System.out.println(e);
	        }  
	        return new ModelAndView("user","contactForm",contactForm);  
	    }  
}

