package com.api.simpleuserscore.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserErrorResponse {
	private int status;
	private String message;
	private long timeStamp;
}







