package com.longyx.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.longyx.common.security.component.MyAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author: Longyx
 * @Package: com.longyx.common.security.exception
 * @ClassName: SophiaAuth2Exception
 * @Description: 自定义OAuth2Exception
 */
@JsonSerialize(using = MyAuth2ExceptionSerializer.class)
public class MyAuth2Exception extends OAuth2Exception {
	@Getter
	private String errorCode;

	public MyAuth2Exception(String msg) {
		super(msg);
	}

	public MyAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
}
