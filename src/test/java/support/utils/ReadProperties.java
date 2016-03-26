package support.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import support.datas.DataProvider;

public class ReadProperties {

	/*
	 * http://stackoverflow.com/questions/9902084/how-to-pass-input-from-command-line-to-junit-maven-test-program 
	 * propertiesConfig can not move to Constant due to hard set in pom.xml 
	 * mvn -clean -test DpropertiesConfig=my_file_name.txt
	 */
	public static String get(String key) {
		Properties obj = new Properties();
		String value = null;
		String remote = System.getProperty("propertiesConfig");
		if (remote == null) {
			value = getData(obj, key);
		} else {
			try {
				InputStream inputStream = new FileInputStream(remote);
				obj.load(inputStream);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			value = obj.getProperty(key);
			if (StringUtils.isEmpty(value)) {
				value = getData(obj, key);
			}
		}
		return StringUtils.trim(value);
	}

	private static String getData(Properties obj, String key) {
		try {
			String file = new DataProvider().getPropertiesFile();
			InputStream inputStream = new FileInputStream(file);
			obj.load(inputStream);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return obj.getProperty(key);
	}

	public List<String> getByPrefix(String prefix) throws Exception {
		Properties obj = new Properties();
		String file = new DataProvider().getPropertiesFile();
		InputStream inputStream = new FileInputStream(file);
		obj.load(inputStream);
		Set<Object> keys = obj.keySet();
		List<String> rs = new ArrayList<String>();
		for (Object k : keys) {
			String key = (String) k;
			if (key.startsWith(prefix)) {
				rs.add(StringUtils.trim(obj.getProperty(key)));
			}
		}
		return rs;
	}
}
