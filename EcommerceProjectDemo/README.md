# 📘 Selenium Hybrid Automation Framework – OnlineStore

This project is a **hybrid test automation framework** developed using **Selenium WebDriver**, **TestNG**, **Page Object Model (POM)**, and **Data-Driven Testing**. It is designed to automate the registration and login functionalities of [TutorialsNinja Demo](https://tutorialsninja.com/demo/) e-commerce site.

## 🚀 Features

- ✅ Hybrid framework with **TestNG**, **Selenium**, and **POM**
- ✅ Supports **Data-Driven Testing** via `@DataProvider`
- ✅ Reusable **ActionDriver** utility for all browser interactions
- ✅ Configurable with `config.properties`
- ✅ Well-structured using **BaseTest**, **BasePage**, and Page Objects
- ✅ Includes **positive and negative test cases** for registration and login
- ✅ Custom assertions and clean reporting

## 🛠️ Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI (optional for Excel data)
- Page Object Model (POM)
- Log4j (optional, if logging included)

## 📁 Folder Structure

```
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.onlinestore.basefile/        # BaseTest setup
│   │   │   ├── com.onlinestore.basepages/       # BasePage with ActionDriver
│   │   │   ├── com.onlinestore.pageobjects/     # Page classes (Register, Login, Home)
│   │   │   ├── com.onlinestore.utils/           # ActionDriver utility
│   │   │   └── com.onlinestore.config/          # ConfigReader and properties
│   ├── test/
│   │   ├── java/
│   │   │   ├── com.onlinestore.testcases/       # Test classes
│   │   │   └── com.onlinestore.testdata/        # DataProvider test data
├── resources/
│   └── config.properties                        # Configuration settings
└── pom.xml                                      # Maven config
```

## ⚙️ Configuration

Update your `config.properties` in `/resources/`:

```properties
url = https://tutorialsninja.com/demo/
browser = chrome
implicit_wait = 10
explicit_wait = 20
```

## 🧪 Test Cases Included

### ✅ Positive Tests:
- Successful User Registration
- Successful Login

### ❌ Negative Tests:
- Registration without accepting privacy policy
- Registration with missing required fields
- Login with invalid credentials
- Login with blank inputs

## 🧬 Sample Data

Stored in `TestData.java` using `@DataProvider` for clean separation of logic and data.

## 🔧 How to Run

1. Clone the repo
2. Configure `config.properties`
3. Run using TestNG Suite XML or directly from the test class

```bash
mvn clean test
```

## 📸 Screenshots & Reports

(Include later if you configure screenshot capture and ExtentReports.)

## 🙌 Author

Pradeep Kumar Baskar  
Selenium | TestNG | Java Automation Engineer  
[GitHub Profile](https://github.com/Pradeepbaskar07)
