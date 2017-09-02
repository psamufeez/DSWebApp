package com.ds.web.util;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;

@SuppressWarnings("serial")
public class DateJsonDeserializer extends DateDeserializers.DateDeserializer {
	
	private Log log = LogFactory.getLog(DateJsonDeserializer.class);
	
	private static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
	
	private static final String[] DATE_FORMAT_PATTERNS = {
		"", // place holder for system date format
		"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", // JavaScript
		"yyyy-MM-dd'T'HH:mm:ssZ", // ISO 8601
	};
	
	public DateJsonDeserializer() {
		log.debug("Initialize@" + this.toString());		
	}

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctx) throws IOException, JsonProcessingException {
		String source = jp.getText().trim();
		try {
			if (source.length() == 0) {
				return super.deserialize(jp, ctx);
			} else {
				DATE_FORMAT_PATTERNS[0] = DEFAULT_DATE_FORMAT;
				return DateUtils.parseDateStrictly(source, DATE_FORMAT_PATTERNS);
			}
		} catch (ParseException e) {
			return super.deserialize(jp, ctx);
		}
	}
}