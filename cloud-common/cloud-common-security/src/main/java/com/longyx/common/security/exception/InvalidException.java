package com.longyx.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.longyx.common.security.component.MyAuth2ExceptionSerializer;

/**
 * @author: Longyx
 * @Package: com.longyx.common.security.exception
 * @ClassName: InvalidException
 */
@JsonSerialize(using = MyAuth2ExceptionSerializer.class)
public class InvalidException extends MyAuth2Exception {

	public InvalidException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "invalid_exception";
	}

	@Override
	public int getHttpErrorCode() {
		return 426;
	}

}
