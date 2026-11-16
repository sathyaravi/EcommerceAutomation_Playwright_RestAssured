# EcommerceAutomation_Playwright_RestAssured

Test automation framework for [automationexercise.com](https://automationexercise.com/), built with Java, Playwright, TestNG, and the Page Object Model. REST Assured API tests are in progress.

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| UI Automation | Playwright for Java |
| API Testing | REST Assured (in progress) |
| Test Framework | TestNG |
| Design Pattern | Page Object Model |
| Build Tool | Maven |

## Project Structure

```
src/
├── main/java/pages/        # Page Objects (HomePage, LoginPage, ...)
└── test/
    ├── java/
    │   ├── base/           # BaseTest (browser setup/teardown)
    │   └── tests/          # TestNG test classes
    └── resources/
        └── testng.xml      # Suite configuration
```

## Current Coverage

- [x] Home page loads
- [ ] User registration and login (valid / invalid)
- [ ] Product search
- [ ] Cart and checkout
- [ ] REST Assured API suite

## How to Run

Prerequisites: JDK 17+, Maven. Playwright downloads its browsers on first run.

```bash
mvn test
```

## Author

**Sathya Ravichandran**, QA Automation Engineer
[LinkedIn](your-linkedin-url) · [GitHub](https://github.com/sathyaravi)
