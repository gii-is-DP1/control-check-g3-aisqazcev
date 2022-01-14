package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType> {

	@Autowired
	private RecoveryRoomService rrservice;

	@Override
	public String print(RecoveryRoomType object, Locale locale) {
		String name = object.getName();
		return name;
	}

	@Override
	public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
		RecoveryRoomType rrtype = this.rrservice.getRecoveryRoomType(text);
		if (rrtype == null) {
			throw new ParseException(text, 0);
		} else {
			return rrtype;
		}
	}

}
