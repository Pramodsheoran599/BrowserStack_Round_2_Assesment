**Selenium Automation Framework 🧪💻**

**Overview**
A modular Selenium framework built with Java, TestNG, and Maven, designed for cross-browser testing, web scraping, and API integration.
The framework follows the Page Object Model (POM) design pattern for scalability and maintainability.

**Task List**

1) Visit the website El País, a Spanish news outlet.
      - Ensure that the website's text is displayed in Spanish.
        
2) Scrape Articles from the Opinion Section:
      - Navigate to the Opinion section of the website.
      - Fetch the first five articles in this section.
      - Print the title and content of each article in Spanish.
      - If available, download and save the cover image of each article to your local machine.
        
3) Translate Article Headers:
      - Use a translation API of your choice, such as:
      - Google Translate API
      - Rapid Translate Multi Traduction API
      - Translate the title of each article to English.
      - Print the translated headers.
        
4) Analyze Translated Headers:
      - From the translated headers, identify any words that are repeated more than twice across all headers combined.
      - Print each repeated word along with the count of its occurrences.

5) Cross-Browser Testing:
      - Run the solution locally to verify functionality.
      - Once validated, execute the solution on BrowserStack across 5 parallel threads, testing across a combination of desktop and mobile browsers.
