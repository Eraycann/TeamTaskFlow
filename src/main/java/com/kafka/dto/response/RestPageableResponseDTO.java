package com.kafka.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestPageableResponseDTO<T> {

	private List<T> content;
	
	private int pageNumber;
	
	private int pageSize;
	
	private Long totalElements;
}
