package com.ds.web.util;

import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SqlTimestampJsonDeserializer extends JsonDeserializer<Timestamp> {
	
	private Log log = LogFactory.getLog(SqlTimestampJsonDeserializer.class);
	
	public SqlTimestampJsonDeserializer() {
		log.debug("Initialize@" + this.toString());
	}

	@Override
	public Timestamp deserialize(JsonParser jp, DeserializationContext ctx) throws IOException, JsonProcessingException {
		String source = jp.getText(); 
		if (StringUtils.isNotEmpty(source)) {
			return Timestamp.valueOf(source);
		} else {
			return null;
		}
	}
	
	@Override
	public Class<Timestamp> handledType() {
		return Timestamp.class;
	}
}