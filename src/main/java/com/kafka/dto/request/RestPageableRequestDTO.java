package com.kafka.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestPageableRequestDTO {

	private int pageNumber;
	
	private int pageSize;
	
	private String columnName;
	
	private boolean asc;
}
