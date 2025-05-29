# CookUnity_Project
CookUnity automation test frontend and api.

This project contains an automated testing suite for the User Interface (Frontend) of to www.cookunity.com and API_url: https://gorest.co.in/, using Java, Selenium WebDriver, and TestNG.

🚀 Getting Started

These instructions will guide you on how to set up the project on your local machine for development and testing.

📋 Prerequisites

Before you begin, ensure you have the following components installed:

Java Development Kit (JDK) 11 or higher:
You can download it from the official Oracle website or use an OpenJDK (such as Adoptium, Amazon Corretto, etc.).

Verify the installation by opening a terminal and running:

Bash

java -version
javac -version

IDE (Integrated Development Environment):
IntelliJ IDEA (Community or Ultimate) or Eclipse IDE is recommended, I used Eclipse IDE.

WebDriver for your preferred browser:
This project is configured by default to use Chrome. You will need the chromedriver.exe (Windows), chromedriver (Linux/macOS) corresponding to your Google Chrome version.
Download it from https://chromedriver.chromium.org/downloads and ensure it is in your system's PATH, or specify its path in the code (Driver configuration section).
If you wish to use Firefox, download geckodriver from https://github.com/mozilla/geckodriver/releases.

⚙️ Installation and Configuration

Follow these steps to set up the project on your machine:

Clone the repository:

Bash

https://github.com/your_username/CookUnity_Project.git
cd CookUnity_Project
Open the Project in your IDE:

Java

System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver");
// Example for Windows: System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
// Example for macOS/Linux: System.setProperty("webdriver.chrome.driver", "/Users/your_username/drivers/chromedriver");
Note: It's better to avoid this and correctly configure your system's PATH for greater flexibility.

config.properties File Configuration (Optional but Recommended):
For better environment and data management, it is recommended to create a src/main/resources/config.properties (or similar) file to store variables such as:

Properties

baseURL=https://www.cookunity.com/
browser=chrome
timeout=20
defaultZipCode=10001
testEmail=qa.mail@gmail.com
testPassword=123123123
Then, you can read these properties in your Java code to make tests more configurable and avoid "hardcoding" values.

🚀 Test Execution

The project is configured to run using TestNG

🎯 Run All Tests

To run all tests defined in the project, open a terminal at the root of the project and execute the following command or being execute with TestNG from IDE:

Bash

test: Executes the test lifecycle, including compiling test code and running tests.
🧪 Run Specific Tests or Groups (Using testng.xml)

The testng.xml file is key for configuring and executing specific test sets, groups, or for parallel execution.

Open testng.xml:
Look for the testng.xml file at the root of your project (or in src/test/resources if it was moved there).

Example testng.xml:

XML

<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.1.dtd" > 
<suite name="CookUnitySanitySuite" verbose="3">
  <test name="CookUnitySanityTest">
    <classes>
      <!-- Commented temporary to avoid test web -->
  	  <!-- <class name="Sanity_test.web_cookunity_test"/> -->
  	  <!-- <class name="Sanity_test.api_cookunity_test"/> -->
  	  <class name="Sanity_test.web_cookunity_test"/>
    </classes>
  </test>
</suite>
Run from the command line with testng.xml: (mac OS)
1. Compile your .java test files (if not compiled yet):
  javac -cp "lib/*" -d bin src/Sanity_test/api_cookunity_test.java

2. Run the test using TestNG runner:
  java -cp "bin:lib/*" org.testng.TestNG testng.xml


Run from the IDE:

IntelliJ IDEA: Right-click on the testng.xml file and select Run 'testng.xml'. This will create a run configuration that you can save and modify.
Eclipse: Right-click on the testng.xml file and select Run As -> TestNG Suite.

Also review lib folder to add manully .jar to the project.

Static Report: 

Frontend task:

===== Invoked methods
    web_cookunity_test.testMealPlanSelection()[pri:0, instance:Sanity_test.web_cookunity_test@639c2c1d]
=====
PASSED: Sanity_test.web_cookunity_test.testMealPlanSelection

===============================================
    CookUnitySanityTest
    Tests run: 1, Failures: 0, Skips: 0
===============================================


===============================================
CookUnitySanitySuite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================

Also a video, Please review 2025-05-28.mp4

API task:

[RemoteTestNG] detected TestNG version 7.11.0
SLF4J(W): No SLF4J providers were found.
SLF4J(W): Defaulting to no-operation (NOP) logger implementation
SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
PASSED: Sanity_test.api_cookunity_test.testMealPlanSelection

===============================================
    Default test
    Tests run: 2, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
===============================================

📧 Contact

For any questions or comments, feel free to contact:
Nelly Flores Rojas - nellyflorearojas@hotmail.com
