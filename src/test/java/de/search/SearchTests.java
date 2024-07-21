/*
 * created by max$
 */


package de.search;

import de.search.utils.DataProviders;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{



    @Test(dataProvider = "ebayData", dataProviderClass = DataProviders.class)
    public void searchEbay(String nameAuto, String year, String maxPrice) {
        new HomePage(driver)
                .ebayNameEnter(nameAuto)
                .enterFind()
                .enterYear(year)
                .ebayMaxPriceEnter(maxPrice)
             //   .enterDiesel()
             //   .enterHande()
                .kontrolPrice();
    }

}
