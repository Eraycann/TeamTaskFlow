package com.kafka.exception;

import lombok.Getter;

@Getter
public enum MessageType {

	NO_RECORD_EXIST("1001", "kayıt bulunamadı"),
	USERNAME_NOT_FOUND("1002", "username bulunamadı"),
	GENERAL_EXCEPTION("9999", "genel bir hata oluştu");
	
	private String code;
	private String message;
	
	private MessageType(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
