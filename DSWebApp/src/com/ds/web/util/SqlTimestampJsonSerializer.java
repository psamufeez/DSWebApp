package com.ds.web.util;

import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class SqlTimestampJsonSerializer extends JsonSerializer<Timestamp> {
	
	private Log log = LogFactory.getLog(SqlTimestampJsonSerializer.class);
	
	public SqlTimestampJsonSerializer() {
		log.debug("Initialize@" + this.toString());
	}

	@Override
	public void serialize(Timestamp value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeString(value.toString());
	}

	@Override
	public Class<Timestamp> handledType() {
		return Timestamp.class;
	}
}