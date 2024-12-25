package com.kafka.utils;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PagerUtil {

	public boolean isNullOrEmpty(String value) {
		return value == null || value.trim().length() == 0;
	}
	
	public Pageable toPageable(RestPageableRequestDTO restPageableRequestDTO) {
		if (!isNullOrEmpty(restPageableRequestDTO.getColumnName())) {
			Sort sortBy = restPageableRequestDTO.isAsc() ? Sort.by(Direction.ASC, restPageableRequestDTO.getColumnName()) : Sort.by(Direction.DESC, restPageableRequestDTO.getColumnName()); 
			return PageRequest.of(restPageableRequestDTO.getPageNumber(), restPageableRequestDTO.getPageSize(), sortBy);
		}
		return PageRequest.of(restPageableRequestDTO.getPageNumber(), restPageableRequestDTO.getPageSize());
	}
	
	public<T> RestPageableResponseDTO<T> toPageableResponse(Page<?> page, List<T> content){
		RestPageableResponseDTO<T> restPageableResponseDTO = new RestPageableResponseDTO<>();
		restPageableResponseDTO.setContent(content);
		restPageableResponseDTO.setPageNumber(page.getPageable().getPageNumber());
		restPageableResponseDTO.setPageSize(page.getPageable().getPageSize());
		restPageableResponseDTO.setTotalElements(page.getTotalElements());
		return restPageableResponseDTO;
	}
}
