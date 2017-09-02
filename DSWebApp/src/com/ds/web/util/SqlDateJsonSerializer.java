package com.ds.web.util;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class SqlDateJsonSerializer extends JsonSerializer<Date> {
	
	private Log log = LogFactory.getLog(SqlDateJsonSerializer.class);
	
	private static final DateFormat defaultFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public SqlDateJsonSerializer() {
		log.debug("Initialize@" + this.toString());
	}

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		String str = defaultFormat.format(value);
		jgen.writeString(str);
	}

	@Override
	public Class<Date> handledType() {
		return Date.class;
	}
}