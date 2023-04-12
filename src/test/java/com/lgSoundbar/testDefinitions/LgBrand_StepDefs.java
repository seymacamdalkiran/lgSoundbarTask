package com.lgSoundbar.testDefinitions;

import com.lgSoundbar.page.LgBrandPage;
import com.lgSoundbar.utilities.BrowserUtils;
import com.lgSoundbar.utilities.ConfigurationReader;
import com.lgSoundbar.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LgBrand_StepDefs {
    @Given("Go to the url")
    public void go_to_the_url() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @Given("Write {string} in the search button and click")
    public void write_in_the_search_button_and_click(String string) {
        LgBrandPage lgBrandPage=new LgBrandPage();
        lgBrandPage.searchAmazonInput.sendKeys(string);
        lgBrandPage.searchButton.click();
    }
    @When("Select lg brand xheckbox")
    public void select_lg_brand_xheckbox() {
        LgBrandPage lgBrandPage=new LgBrandPage();
        try {
            BrowserUtils.clickWithJS(lgBrandPage.lgBrand);
        } catch (Exception e) {
            Driver.closeDriver();
            Driver.get();
            go_to_the_url();
            write_in_the_search_button_and_click("LG soundbar");
            select_lg_brand_xheckbox();
        }
    }
    @When("Read product price and name")
    public void read_product_price_and_name() {
        LgBrandPage lgBrandPage=new LgBrandPage();
        lgBrandPage.sortProduct1(lgBrandPage.productNames);
    }
    @When("Print product price and name in desc order of price via code.")
    public void print_product_price_and_name_in_desc_order_of_price_via_code() {

    }

}
