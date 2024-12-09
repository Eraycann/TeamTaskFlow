package com.kafka.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseDTO {

	private Long id;
	
	private LocalDateTime createdAt;
}
