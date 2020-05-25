package PO;

import Utils.Screenshot;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    String handler;
    public Logger logger = LogManager.getLogger(this.getClass());

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickTabs() {
        try {
            overview = driver.findElement(By.xpath(item_link_tabs + "[1]"));
            overview.click();
            waiter(1);
            Screenshot.saveScreenshot(driver, "1. Overview Tab");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(item_link_tabs + "[2]")))).isDisplayed();
            waiter(5);
            facilities = driver.findElement(By.xpath(item_link_tabs + "[2]"));
            facilities.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(comfort))).isDisplayed();
            driver.findElement(By.xpath(more)).click();
            Screenshot.saveScreenshot(driver, "2. Facilities Tab");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(nav_panel)))).isDisplayed();
            rooms = driver.findElement(By.xpath(item_link_tabs + "[8]"));
            rooms.click();
            Screenshot.saveScreenshot(driver, "3. Rooms Tab");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(nav_panel)))).isDisplayed();
            locations = driver.findElement(By.xpath(item_link_tabs + "[9]"));
            locations.click();
            Screenshot.saveScreenshot(driver, "4. Locations Tab");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(nav_panel)))).isDisplayed();
            reviews = driver.findElement(By.xpath(item_link_tabs + "[10]"));
            reviews.click();
            Screenshot.saveScreenshot(driver, "5. Reviews Tab");
        } catch (Exception e) {
            logger.error(e);
        }
        return this;
    }

    public MainPage fillDates() {
        try {
            driver.findElement(By.xpath(check_rooms_prices));
            date_input = driver.findElement(By.xpath(date_from));
            wait.until(ExpectedConditions.elementToBeClickable(date_input));
            Thread.sleep(2000);
            date_input.click();
            start_date = driver.findElement(By.xpath(start_date_value));
            start_date.click();
            end_date = driver.findElement(By.xpath(end_date_value));
            end_date.click();
        } catch (Exception e) {
            logger.error(e);
        }
        return this;
    }

    public MainPage fillGuests() {
        try {
            room_guests_block = driver.findElement(By.xpath(rooms_guests));
            room_guests_block.click();
            add_adult = driver.findElement(By.xpath(plus_btn + "[1]"));
            add_adult.click();
            add_kid = driver.findElement(By.xpath(plus_btn + "[2]"));
            add_kid.click();
            add_kid.click();
            age_kid1 = driver.findElement(By.xpath(kid_age_select + "[1]"));
            age_kid1.click();
            age_kid1_value = driver.findElement(By.xpath(age_value1));
            age_kid1_value.click();
            age_kid2 = driver.findElement(By.xpath(kid_age_select + "[2]"));
            age_kid2.click();
            age_kid2_value = driver.findElement(By.xpath(age_value2));
            age_kid2_value.click();
        } catch (Exception e) {
            logger.error(e);
        }
        return this;
    }

    public MainPage checkGuests() {
        try {
            guest_count = driver.findElement(By.xpath(guests_span));
            String count_guest = guest_count.getText();
            room_count = driver.findElement(By.xpath(rooms_span));
            String count_room = room_count.getText();
            handler = driver.getWindowHandle();
            if (count_guest.equals("5 Гостей") && count_room.equals("1 Номер")) {
                apply_btn = driver.findElement(By.xpath(apply));
                apply_btn.click();
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return this;
    }

    public void bookRoom() {
        try {
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
            if (driver.findElements(By.xpath(rooms_entity)).isEmpty()) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(book_text)));
                book_room = driver.findElement(By.xpath(book_text));
                book_room.click();
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public String[] checkDates() {
        try {
            checkoutPageLoadingWait();
            Screenshot.saveScreenshot(driver, "Checkout Page");
            actualResult[0] = driver.findElement(By.xpath(month_day + "[1]")).getText();
            actualResult[1] = driver.findElement(By.xpath(year_month + "[1]")).getText();
            actualResult[2] = driver.findElement(By.xpath(month_day + "[2]")).getText();
            actualResult[3] = driver.findElement(By.xpath(year_month + "[2]")).getText();
        } catch (Exception e) {
            logger.error(e);
        }
        return actualResult;
    }

}
