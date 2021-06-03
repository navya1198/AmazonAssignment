package reusableComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations {

	
	static Properties prop = new Properties();
	
	public static String getPropertyValueByKey(String key) throws Exception
	{
		System.out.println(key);
		String propFilePath=System.getProperty("user.dir") + "\\Resources\\config.properties";
		FileInputStream fis=new FileInputStream(propFilePath);
		prop.load(fis);
		
		
		//read data
		String value=prop.get(key).toString();
		
		System.out.println(value);
		if(StringUtils.isEmpty(value))
		{
			throw new Exception("Value is not specified for key: "+key+ " in properties file");
			
		}
		
		
		return value;
		
		
	}
}
