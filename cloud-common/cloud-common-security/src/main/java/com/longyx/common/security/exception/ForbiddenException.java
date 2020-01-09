package com.longyx.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.longyx.common.security.component.MyAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author: Longyx
 * @Package: com.longyx.common.security.exception
 * @ClassName: ForbiddenException
 */
@JsonSerialize(using = MyAuth2ExceptionSerializer.class)
public class ForbiddenException extends MyAuth2Exception {

	public ForbiddenException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "access_denied";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.FORBIDDEN.value();
	}

}

