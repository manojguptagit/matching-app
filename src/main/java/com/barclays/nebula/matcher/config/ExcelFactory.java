package com.barclays.nebula.matcher.config;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.poiji.exception.PoijiExcelType;

public class ExcelFactory {

	private static final Logger logger = LoggerFactory.getLogger(ExcelFactory.class);

	public static PoijiExcelType getExcelType(MultipartFile multipartFile) {
		if (multipartFile == null) {
			throw new IllegalArgumentException("File should not be null");
		}
		if (multipartFile.getContentType().equalsIgnoreCase("application/vnd.ms-excel")) {
			return PoijiExcelType.XLS;
		} else if (multipartFile.getContentType()
				.equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return PoijiExcelType.XLSX;
		} else {
			throw new IllegalArgumentException("Uploaded file is not a excel file");
		}
	}

	public static Workbook getWorkBook(MultipartFile multipartFile) {

		if (multipartFile == null) {
			throw new IllegalArgumentException("File should not be null");
		}
		if (multipartFile.getContentType().equalsIgnoreCase("application/vnd.ms-excel")) {
			try {
				return new HSSFWorkbook(multipartFile.getInputStream());
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		} else if (multipartFile.getContentType()
				.equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			try {
				return new XSSFWorkbook(multipartFile.getInputStream());
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		} else {
			throw new IllegalArgumentException("Uploaded file is not a excel file");
		}
		return null;
	}

	private ExcelFactory() {
	}
}
