package com.pdf.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;





public class ExcelMapping {
	
	private static final Logger _LOGGER = Logger.getLogger(ExcelMapping.class);
	public static LinkedHashMap<String, String> readExcel(Workbook workbook ){

LinkedHashMap <String, String> valuesMap=new LinkedHashMap<String, String>();
		
		
		
		int columnIndex=0;
		try{
			String headerName = "";
			
		_LOGGER.info("Total sheets in excel::"+workbook.getNumberOfSheets());
	    Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		_LOGGER.info("Started Processing Product");
	   
	    String xid = null;
	    
	   
		Row headerRow = null;
		while (iterator.hasNext()) {
			try{
			Row nextRow = iterator.next();
		
			if (nextRow.getRowNum() == 0) {
				headerRow = nextRow;
				continue;
			}
			
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			
			 boolean checkXid  = false; //imp line
			//boolean checkXid  = true; //imp line
			//xid=getProductXid(nextRow);
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
			    columnIndex = cell.getColumnIndex();
			    if (columnIndex == 0) {
					continue;
				}
				headerName = getHeaderName(columnIndex, headerRow);
				switch (headerName) {
					    /*case 1://XID
						//productId=xid;//CommonUtility.getCellValueStrinOrInt(cell);
					String str=getCellValueStrinOrInt(cell);
						break;*/
					    case "DOCUMENT ID":
					    	String str=getCellValueStrinOrInt(cell);
							break;
					    case "REMOTE ID":
					    	String str1=getCellValueStrinOrInt(cell);
							break;
					    case "FILENAME":
					    	String FILENAME=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(FILENAME)){
					    	valuesMap.put(headerName, FILENAME);
					    	}
							break;
					    case "RECEIVED AT":
					    	String str3=getCellValueStrinOrInt(cell);
							break;
					    case "PROCESSED AT":
					    	String str4=getCellValueStrinOrInt(cell);
							break;
					    case "MAINADDRESS":
					    	String MAINADDRESS=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(MAINADDRESS)){
					    	valuesMap.put(headerName, MAINADDRESS);
					    	}
							break;
					    case "OFFICENO":
					    	String OFFICENO=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(OFFICENO)){
					    		OFFICENO=OFFICENO.replace("Office:", "");
					    	valuesMap.put(headerName, OFFICENO);
					    	}
					    	break;
					    case "EMAILID":
					    	String EMAILID=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(EMAILID)){
					    		EMAILID=EMAILID.replace("Email:", "");
					    	valuesMap.put(headerName, EMAILID);
					    	}
					    	break;
					    case "SALESPERSON":
					    	String SALESPERSON=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(SALESPERSON)){
					    	valuesMap.put(headerName, SALESPERSON);
					    	}
					    	break;
					    case "ORDERNO":
					    	String ORDERNO=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(ORDERNO)){
					    	valuesMap.put(headerName, ORDERNO);
					    	}
					    	break;
					    case "ORDERDATE":
					    	String ORDERDATE=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(ORDERDATE)){
					    	valuesMap.put(headerName, ORDERDATE);
					    	}
					    	break;
					    case "INVOICEDATE":
					    	String INVOICEDATE=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(INVOICEDATE)){
					    	valuesMap.put(headerName, INVOICEDATE);
					    	}
					    	break;
					    case "BILLADDRESS":
					    	String BILLADDRESS=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(BILLADDRESS)){
					    	valuesMap.put(headerName, BILLADDRESS);
					    	}
					    	break;
					    case "SHIPADDRESS":
					    	String SHIPADDRESS=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(SHIPADDRESS)){
					    	valuesMap.put(headerName, SHIPADDRESS);
					    	}
					    	break;
					    case "CUSTOMERNO":
					    	String CUSTOMERNO=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(CUSTOMERNO)){
					    	valuesMap.put(headerName, CUSTOMERNO);
					    	}
					    	break;
					    case "TERMS":
					    	String TERMS=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(TERMS)){
					    	valuesMap.put(headerName, TERMS);
					    	}
					    	break;
					    case "METHOD":
					    	String METHOD=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(METHOD)){
					    		METHOD=METHOD.replace("d:", "");
					    	valuesMap.put(headerName, METHOD);
					    	}
					    	break;
					    case "SHIPVIA":
					    	String SHIPVIA=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(SHIPVIA)){
					    		SHIPVIA=SHIPVIA.replace("a:", "");
					    	valuesMap.put(headerName, SHIPVIA);
					    	}
					    	break;
					    case "SHIPACCOUNT":
					    	String SHIPACCOUNT=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(SHIPACCOUNT)){
					    		SHIPACCOUNT=SHIPACCOUNT.replace("t:", "");
					    	valuesMap.put(headerName, SHIPACCOUNT);
					    	}
					    	break;
					    case "QUANTITY":
					    	String QUANTITY=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(QUANTITY)){
					    		QUANTITY=QUANTITY.replace("G", "");
					    	valuesMap.put(headerName, QUANTITY);
					    	}
					    	break;
					    case "PRODUCTNAME":
					    	String PRODUCTNAME=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(PRODUCTNAME)){
					    	valuesMap.put(headerName, PRODUCTNAME);
					    	}
					    	break;
					    case "DESCRIPTION":
					    	String DESCRIPTION=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(DESCRIPTION)){
					    	valuesMap.put(headerName, DESCRIPTION);
					    	}
					    	break;
					    case "UNIT":
					    	String UNIT=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(UNIT)){
					    	valuesMap.put(headerName, UNIT);
					    	}
					    	break;
					    case "PRODUCTPRICE":
					    	String PRODUCTPRICE=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(PRODUCTPRICE)){
					    	valuesMap.put(headerName, PRODUCTPRICE);
					    	}
					    	break;
					    case "PRICEPER":
					    	String PRICEPER=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(PRICEPER)){
					    	valuesMap.put(headerName, PRICEPER);
					    	}
					    	break;
					    case "TOTALPRICE":
					    	String TOTALPRICE=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(TOTALPRICE)){
					    	valuesMap.put(headerName, TOTALPRICE);
					    	}
					    	break;
					    case "ORDERTOTAL":
					    	String ORDERTOTAL=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(ORDERTOTAL)){
					    	valuesMap.put(headerName, ORDERTOTAL);
					    	}
					    	break;
					    case "TOTALDUE":
					    	String TOTALDUE=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(TOTALDUE)){
					    	valuesMap.put(headerName, TOTALDUE);
					    	}
					    	break;
					    case "INSTRUCTION":
					    	String INSTRUCTION=getCellValueStrinOrInt(cell);
					    	if(!StringUtils.isEmpty(INSTRUCTION)){
					    	valuesMap.put(headerName, INSTRUCTION);
					    	}
					    	
					    	break;
						
				}  // end inner while loop					 
			}		
			}catch(Exception e){
				_LOGGER.error("Error while Processing excel sheet " +e.getMessage()+"at column"+columnIndex);
				}
		}
		workbook.close();
		
		}catch(Exception e){
			_LOGGER.error("Error while Processing excel sheet " +e.getMessage());
		//return finalResult;
		}finally{
			try {
				workbook.close();
			} catch (IOException e) { 
				_LOGGER.error("Error while Processing excel sheet" +e.getMessage());
	
			}
				_LOGGER.info("Complted processing of excel sheet ");
				
		}
		return valuesMap;
		
	}
	private static String getHeaderName(int columnIndex, Row headerRow) {
		Cell cell2 = headerRow.getCell(columnIndex);
		String headerName = getCellValueStrinOrInt(cell2);
		// columnIndex = ProGolfHeaderMapping.getHeaderIndex(headerName);
		return headerName.toUpperCase();
	}
	public static String getCellValueStrinOrInt(Cell cell) {
		String value = "";
		try {
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				value = cell.getStringCellValue().trim();
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				int numericValue = (int) cell.getNumericCellValue();
				value = String.valueOf(numericValue).trim();
			}else if(cell.getCellType() == Cell.CELL_TYPE_ERROR){
				//value = String.valueOf(cell.getErrorCellValue());
				value = Byte.toString(cell.getErrorCellValue()).trim();
				value="";
			}else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){
				//value = String.valueOf(cell.getErrorCellValue());
				boolean val = cell.getBooleanCellValue();
				value=String.valueOf(val);
			}
			
		} catch (Exception e) {
			/*_LOGGER.error("Cell value convert into String/Int format: "
					+ e.getMessage());*/
		}

		return value;
	}

}
