import PO.BasePage;
import PO.MainPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainTest extends TestSetUp {
    private MainPage mainPage;

    @BeforeMethod
    public void testSetUp() {
        mainPage = new MainPage(this.driver);
    }

    @Test
    public void testBookingRoom() {
        mainPage.openPage();
        mainPage.mainPageLoadingWait();
        mainPage.clickTabs()
                .fillDates()
                .fillGuests()
                .checkGuests()
                .bookRoom();
        String[] expectedResult = new String[]{"30", "Май2020", "31", "Май2020"};
        Assert.assertEquals(mainPage.checkDates(), expectedResult);
    }
}