package com.kafka.handler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exception<E> {

	private String path;
	
	private LocalDateTime createTime;
	
	private String hostName;
	
	private E message;
}
