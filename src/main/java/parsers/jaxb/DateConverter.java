package parsers.jaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter extends XmlAdapter<String, Date> {
    private static final String CUSTOM_FORMAT_STRING = "dd/mm/yyyy";

    @Override
    public String marshal(Date v) {
        return new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(v);
    }

    @Override
    public Date unmarshal(String v) throws ParseException {
        return new SimpleDateFormat(CUSTOM_FORMAT_STRING).parse(v);
    }
}
