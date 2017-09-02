package com.ds.web.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateJsonSerializer extends JsonSerializer<Date> {
	
	private Log log = LogFactory.getLog(DateJsonSerializer.class);
		
	private DateFormat jsDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); 
	
	public DateJsonSerializer() {
		log.debug("Initialize@" + this.toString());
	}

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		String s = jsDateFormat.format(value);
		jgen.writeString(s);
	}

	@Override
	public Class<Date> handledType() {
		return Date.class;
	}
}