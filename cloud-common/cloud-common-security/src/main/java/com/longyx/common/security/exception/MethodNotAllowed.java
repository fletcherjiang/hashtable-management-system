package com.longyx.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.longyx.common.security.component.MyAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author: Longyx
 * @Package: com.longyx.common.security.exception
 * @ClassName: MethodNotAllowed
 */
@JsonSerialize(using = MyAuth2ExceptionSerializer.class)
public class MethodNotAllowed extends MyAuth2Exception {

	public MethodNotAllowed(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "method_not_allowed";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.METHOD_NOT_ALLOWED.value();
	}

}
