package com.longyx.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.longyx.common.security.component.MyAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author: Longyx
 * @Package: com.longyx.common.security.exception
 * @ClassName: UnauthorizedException
 */
@JsonSerialize(using = MyAuth2ExceptionSerializer.class)
public class UnauthorizedException extends MyAuth2Exception {

	public UnauthorizedException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "unauthorized";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.UNAUTHORIZED.value();
	}

}
