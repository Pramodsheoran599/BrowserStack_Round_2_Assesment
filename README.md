<h1>Browserstack Assessment Round Test🧪💻</h1>

<h2>Overview</h2>
A modular Selenium framework built with Java, TestNG, and Maven, designed for cross-browser testing using Browserstack, web scraping, and API integration.
The framework follows the Page Object Model (POM) design pattern for scalability and maintainability.

<h3>Task List</h3>

1) Visit the website El País, a Spanish news outlet.
      - Ensure that the website's text is displayed in Spanish.
        
2) Scrape Articles from the Opinion Section:
      - Navigate to the Opinion section of the website.
      - Fetch the first five articles in this section.
      - Print the title and content of each article in Spanish.
      - If available, download and save the cover image of each article to your local machine.
        
3) Translate Article Headers:
      - Use a translation API of your choice, such as Google Translate API or Rapid Translate Multi Traduction API
      - Translate the title of each article to English.
      - Print the translated headers.
        
4) Analyze Translated Headers:
      - From the translated headers, identify any words that are repeated more than twice across all headers combined.
      - Print each repeated word along with the count of its occurrences.

5) Cross-Browser Testing:
      - Run the solution locally to verify functionality.
      - Once validated, execute the solution on BrowserStack across 5 parallel threads, testing across a combination of desktop and mobile browsers.
  

**Note : To Execute this project on browser stack you will need to do below things:**
<br>
      1) Generate Access key for the Rapid Translate Multi Traduction and save it as the environment variable : RAPID_API_TRANSLATE_KEY
 <br>
      2) Replace your browserstack username and accesskey in browserstack.yml file in root directory
