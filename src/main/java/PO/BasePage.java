package PO;

import Utils.PropertyLoader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    String[] actualResult = new String[4];

    WebElement overview, facilities, rooms, locations, reviews, date_input, start_date, end_date,
            room_guests_block, add_adult, add_kid, age_kid1, age_kid2, age_kid1_value, age_kid2_value,
            guest_count, room_count, apply_btn, book_room;

    String close_btn = "(//span[@class=\"fixed-form-close-btn js-hide-check-avail\"])[2]";
    String nav_panel = "(//ul[@class=\"nav-list js-nav-menu\"])[2]";
    String item_link_tabs = "(//a[@class=\"item-link\"])";
    String check_form = "(//div[@class=\"check-form-wrapper clearfix\"])[2]";
    String comfort = "//div[@class=\"basic-title basic-border\"]";
    String more = "//span[@class=\"js-expand-basic-btn expand-btn more-btn\"]";
    String check_rooms_prices = "(//div[@class=\"__check-title basic-border\"])[1]";
    String date_from = "(//div[@class=\"check-input basic-input js-basic-field js-open-calendar\"])[1]";
    String rooms_guests = "(//div[@class=\"check-input basic-input js-r-and-g-btn\"])[1]";
    String start_date_value = "(//div[contains(text(), \"30\")])[2]";
    String end_date_value = "(//div[contains(text(), \"31\")])[1]";
    String plus_btn = "(//div[@class=\"js-add btn-add\"])";
    String kid_age_select = "(//select[@class=\"child-age-select js-select-age\"])";
    String age_value1 = "(//option[@value=\"2\"])[1]";
    String age_value2 = "(//option[@value=\"10\"])[2]";
    String guests_span = "(//span[@class=\"js-guest-count guest-count\"])[1]";
    String rooms_span = "(//span[@class=\"js-rooms-count rooms-count\"])[1]";
    String apply = "//button[@class=\"basic-btn __btn-check hide-tablet js-change js-check-avail-pop js-get-price-btn js-gtm-hp-check-avail-btn\"]";
    String book_page_title = "(//div[@class=\"book-page__title\"])[1]";
    String rooms_entity = "//div[@id=\"hotel-608662\"]";
    String book_text = "(//button)[5]";
    String month_day = "(//span[@class=\"data-row room-info-data month-day\"])";
    String year_month = "(//span[@class=\"data-row room-info-data year-month\"])";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
    }

    public void openPage() {
        driver.get(PropertyLoader.loadProperty("URL"));
    }

    public void mainPageLoadingWait() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(check_form))).isDisplayed();
        driver.findElement(By.xpath(close_btn)).click();
    }

    public void checkoutPageLoadingWait() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(book_page_title))).isDisplayed();
    }

    public void waiter(long l) {
        driver.manage().timeouts().implicitlyWait(l, TimeUnit.SECONDS);

    }
}