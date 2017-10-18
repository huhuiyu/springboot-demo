package cn.huhuiyu.demo.springboot.mybatis.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * 
 * @author huhuiyu
 *
 */
public class StringToDateConverter implements Converter<String, Date> {

	private static final String SPLIT3 = "/";
    private static final String SPLIT2 = ":";
    private static final String SPLIT1 = "-";
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";

	private static final String DATE_FORMAT2 = "yyyy/MM/dd HH:mm:ss";
	private static final String SHORT_DATE_FORMAT2 = "yyyy/MM/dd";

	@Override
	public Date convert(String source) {
		if (StringUtils.isEmpty(source)) {
			return null;
		}
		source = source.trim();
		try {
			SimpleDateFormat formatter;
			if (source.contains(SPLIT1)) {
				if (source.contains(SPLIT2)) {
					formatter = new SimpleDateFormat(DATE_FORMAT);
				} else {
					formatter = new SimpleDateFormat(SHORT_DATE_FORMAT);
				}
				Date dtDate = formatter.parse(source);
				return dtDate;
			} else if (source.contains(SPLIT3)) {
				if (source.contains(SPLIT2)) {
					formatter = new SimpleDateFormat(DATE_FORMAT2);
				} else {
					formatter = new SimpleDateFormat(SHORT_DATE_FORMAT2);
				}
				Date dtDate = formatter.parse(source);
				return dtDate;
			}
		} catch (Exception e) {
			throw new RuntimeException(String.format("parser %s to Date fail", source));
		}

		throw new RuntimeException(String.format("parser %s to Date fail", source));
	}

}
