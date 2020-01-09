package com.longyx.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.longyx.common.security.component.MyAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author: Longyx
 * @Package: com.longyx.common.security.exception
 * @ClassName:  ServerErrorException
 */
@JsonSerialize(using = MyAuth2ExceptionSerializer.class)
public class ServerErrorException extends MyAuth2Exception {

	public ServerErrorException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "server_error";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

}
