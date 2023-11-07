package learnappium.Appium_Mobile;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

	public static Properties properties;
	public static String propertyFilePath= "src/test/java/resource/configData.properties";

	public static void ConfigFileReaders(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
				} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}

	public String getTeam_name(){
		String team_name = properties.getProperty("team_name");
		if(team_name!= null) return team_name;
		else throw new RuntimeException("team_name is not specified in the Configuration.properties file");
	}
	public String getDevice_name(){
		String device_name = properties.getProperty("device_name");
		if(device_name!= null) return device_name;
		else throw new RuntimeException("device_name is not specified in the Configuration.properties file");
	}
	public String getUDID_name(){
		String ud_id = properties.getProperty("ud_id");
		if(ud_id!= null) return ud_id;
		else throw new RuntimeException("ud_id is not specified in the Configuration.properties file");
	}
	public File getAppiumjspath_name(){
		String appiumJS_path = properties.getProperty("appiumJS_path");
		if(appiumJS_path!= null) return new File(appiumJS_path);
		else throw new RuntimeException("appiumJSpath is not specified in the Configuration.properties file");
	}
}
