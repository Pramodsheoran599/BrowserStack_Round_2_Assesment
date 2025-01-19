package PageObjects;

import org.openqa.selenium.By;

public class ElPaisHomePage {

    public By hamburgerMenu(){
        return By.id("btn_open_hamburger");
    }

    public By hamburgerMenuItem(String title){
        return By.xpath("//div[@id = 'hamburger_container']//a[contains(@href, '/"+title+"/')]");
    }

    public By acceptBtn(){
        return By.xpath("//button/span[text() = 'Accept'] | //a[text() = 'Accept and continue']");
    }
}
