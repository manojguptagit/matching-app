package com.barclays.nebula.matcher.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.barclays.nebula.matcher.config.ExcelFactory;
import com.barclays.nebula.matcher.service.MatchingService;
import com.barclays.nebula.matcher.vo.ExcelModelVO;
import com.poiji.bind.Poiji;

import me.xdrop.fuzzywuzzy.FuzzySearch;

@Service
public class MatchingServiceImpl implements MatchingService {

	private static final Logger logger = LoggerFactory.getLogger(MatchingServiceImpl.class);

	@Override
	public List<ExcelModelVO> getExcelFileContents(MultipartFile file) {
		InputStream inputStream = null;
		List<ExcelModelVO> excelModelVOs = Collections.emptyList();
		try {
			inputStream = file.getInputStream();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		if (Objects.nonNull(inputStream)) {
			excelModelVOs = Poiji.fromExcel(inputStream, ExcelFactory.getExcelType(file), ExcelModelVO.class);
			excelModelVOs.forEach(element -> {
				int partialRatio = FuzzySearch.partialRatio(element.getFissAddress(), element.getSdsAddress());
				int tokenSetPartialRatio = FuzzySearch.tokenSetPartialRatio(element.getFissAddress(),
						element.getSdsAddress());
				float average = (partialRatio + tokenSetPartialRatio) / 2;
				element.setMatchingScore(average);
			});
		}
		return excelModelVOs;
	}

}
