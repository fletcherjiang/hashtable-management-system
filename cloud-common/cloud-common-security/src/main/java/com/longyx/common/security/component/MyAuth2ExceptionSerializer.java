package com.longyx.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.longyx.common.base.constants.GlobalsConstants;
import com.longyx.common.security.exception.MyAuth2Exception;
import lombok.SneakyThrows;

/**
 * @author: Longyx
 * @Package: com.longyx.common.security.component
 * @ClassName: MyAuth2ExceptionSerializer
 * @Description: OAuth2 异常格式化
 */
public class MyAuth2ExceptionSerializer extends StdSerializer<MyAuth2Exception> {


	public MyAuth2ExceptionSerializer() {
		super(MyAuth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(MyAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
		gen.writeStartObject();
		gen.writeObjectField("code", GlobalsConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}
}
