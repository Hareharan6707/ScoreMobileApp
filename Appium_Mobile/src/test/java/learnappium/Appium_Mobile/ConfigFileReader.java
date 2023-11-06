package learnappium.Appium_Mobile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader extends BaseTest {

	private Properties properties;
	private final String propertyFilePath= fp.getAbsolutePath();

	public ConfigFileReader(){
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
}
