
# Score Mobile App - Appium Automation

<img src="https://i.ytimg.com/vi/tMKC98uOj5Y/maxresdefault.jpg"  width="50%" height="10%">

This project entails a concise examination of the validation process for the successful retrieval of data from the desired landing pages within the 'theScore' digital sports media application. It focuses on the assessment of interactions with key page objects and elements to ensure the seamless functionality and user experience.


## Authors

- [Hareharan Sivashanmugam](https://www.linkedin.com/in/haree6707/)
  
## gif Demo 

![](https://github.com/Hareharan6707/ScoreMobileApp/blob/main/ezgif.com-video-to-gif.gif)


## Environment setup

Below are the pre-requisties/dependencies that needs to be in place for this test to run successfully. 

- Appium server v2.0.1
- Java version 11 
- appium-java-client v9.0.0
- selenium-java-client v4.14.1
- Node.js v20.9.0
- TestNG v7.7.0
- Aventstack extent reports v5.0.5 (Test report handling)
- Android 13.0
- emulator ABI x86_64 , API_level 33
- Maven complier plugin v3.8.1

Note: pom.xml file can be referred for actual version related information for the dependencies

## Resources 

- Navigate to **src/test/java/resources** to view the below apk file and property file. 
- **Application Build**: theScore app v23.14.0 (from apkmirror.com)
- **configData.properties** file containing :
    1. *device_name* of the emulator 
    2. *ud_id* incase of a real device
    3. *team_name* to be searched during test run 

![alt text](https://github.com/Hareharan6707/ScoreMobileApp/blob/main/configDatafile.png)

- Make the necessary changes in property file of modifying the device_name and ud_id  according to test host system. 


## Initialization 

### Change in Appium server invoke path:
- Navigate to src/test/java/learnappium.Appium_Mobile folder from the content root(Appium_Mobile project).
- All necessary class files are available inside this path. 
- Open 'BaseTest.java' file and scroll to the line no.44

![Alt text](https://github.com/Hareharan6707/ScoreMobileApp/blob/main/usernameEdit_basetest.png)

- Edit the user name (highlighted with cursor) to local host's user name inside which npm modules are installed.

### Change in desired capabilities based on test host:

#### Running via real device :

- No changes in 'BaseTest.java'

#### Running via Emulator :

- In 'BaseTest.java' file scroll down

1. Remove the commented codes from line no.58 - 60
2. Comment out line no.61

![alt text](https://github.com/Hareharan6707/ScoreMobileApp/blob/main/emulatorCapabilities.png)

## Test Execution 

Script be run by two ways 
-  Directly from **testng.xml** file from the root directory
-  From **src/test/java/learnappium.Appium_Mobile** - ScoreAPP.java file

## Test Rationale  

- The choice of a **Maven-based architecture** for our Appium test automation project was driven by a commitment to scalability, maintainability, and efficiency. 
- Maven streamlines project management, allowing seamless integration of essential dependencies like Selenium, TestNG, and the Appium Java client. 
- This architecture ensures consistent and repeatable test execution across various devices and platforms while enabling easy reporting through Spark Reports. 
- The result is a professional, technically robust framework that optimizes test development and execution, ultimately enhancing our software quality and testing efficiency.

## Coverage Assessment 

The Appium test automation project performed a thorough coverage examination of the Score digital sports media app, verifying its strong functionality. 
    
* Successfully opened the selected league, team, or player page, confirming that it was shown correctly. 
* Confirmed accurate navigation and data display tailored to the relevant entity by tapping on a sub-tab, such as league table or stats. 
* The test successfully validated seamless back navigation, guaranteeing a smooth return to the previous page. 

This technical accomplishment, which leveraged Maven, Selenium, TestNG, Spark Reports, and the Appium Java client, highlights the project's fullfillment in testing the provided functionalities of the Score app.



