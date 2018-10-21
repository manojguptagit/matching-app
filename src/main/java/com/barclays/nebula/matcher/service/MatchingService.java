package com.barclays.nebula.matcher.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.barclays.nebula.matcher.vo.ExcelModelVO;

public interface MatchingService {
	List<ExcelModelVO> getExcelFileContents(MultipartFile file);
}
