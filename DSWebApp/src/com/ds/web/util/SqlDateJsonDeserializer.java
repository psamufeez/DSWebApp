package com.ds.web.util;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SqlDateJsonDeserializer extends JsonDeserializer<Date> {
	
	private Log log = LogFactory.getLog(SqlDateJsonDeserializer.class);
	
	private DateFormat defaultFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public SqlDateJsonDeserializer() {
		log.debug("Initialize@" + this.toString());
	}

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctx) throws IOException, JsonProcessingException {
		String source = jp.getText(); 
		try {
			if (source != null && !source.trim().equals("")) {
				java.util.Date d = defaultFormat.parse(source);
				return new Date(d.getTime());
			} else {
				return null;
			}
		} catch (ParseException e) {
			throw ctx.weirdStringException(source, Date.class, "Unaable to parse date.");
		}
	}

	@Override
	public Class<Date> handledType() {
		return Date.class;
	}
}