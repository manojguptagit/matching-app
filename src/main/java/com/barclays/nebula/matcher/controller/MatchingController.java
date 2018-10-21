package com.barclays.nebula.matcher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.barclays.nebula.matcher.service.MatchingService;
import com.barclays.nebula.matcher.vo.ExcelModelVO;

@RestController
@RequestMapping(path = "/api/matching")
@CrossOrigin(origins = "*")
public class MatchingController {

	@Autowired
	private MatchingService matchingService;

	@PostMapping
	public List<ExcelModelVO> readExcelFile(@RequestParam("file") MultipartFile file) {
		List<ExcelModelVO> excelModelVOs = this.matchingService.getExcelFileContents(file);
		return excelModelVOs;
	}
}
