package PageObjects;

import org.openqa.selenium.By;

public class OpinionsPage {

    public By articleHeading(){
        return By.xpath("//article//h2");
    }

    public By articleContent(){
        return By.xpath("//article//p");
    }

    public By articleImageBasedOnArticleIndex(int articleIndex){
        return By.xpath("(//article)["+ articleIndex +"]//img");
    }

    public By opinionHeader() {
        return By.xpath("//a[@title = 'Opinión']");
    }
}

