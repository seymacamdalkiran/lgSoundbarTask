package com.lgSoundbar.page;

import com.lgSoundbar.utilities.BrowserUtils;
import com.lgSoundbar.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class LgBrandPage extends BasePage{
    @FindBy(xpath = "//li[@id='p_89/LG']//input[@type='checkbox']")
    public WebElement lgBrand;
   // @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-size-medium a-color-base a-text-normal']")
    public List<WebElement> productNames;
    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']")
    public List<WebElement> allProducts;
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole']")
    public List<WebElement> productPrices;
    public void sortProduct(List<WebElement> product){
        List<String> concatenatedList = new ArrayList<>();
        for (int i = 2; i <=product.size() ; i++) {
            WebElement names = Driver.get().findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])["+
                    i+"]//span[@class='a-size-medium a-color-base a-text-normal']"));
            String key = names.getText();
            WebElement prices = null;
            String value;
            try {
                prices = Driver.get().findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])["+
                        i+"]//span[@class='a-price-whole']"));
                value = prices.getText();
            } catch (Exception e) {
                value="0,000";
            }
            String str=value+" : "+key;
            concatenatedList.add(str);
        }
        List<String> result = sortList(concatenatedList);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
    public List<String> sortList(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            int i2 = list.get(i).indexOf(" ");
            String is = list.get(i).substring(0, i2).replace(",",".");
            double i1=Double.parseDouble(is);
            double j1=0;
            for (int j = 0; j < list.size() ; j++) {
                int i3 = list.get(j).indexOf(" ");
                String js = list.get(j).substring(0, i3).replace(",",".");
                j1=Double.parseDouble(js);
                if(i1>j1){
                    String temp=list.get(i);
                    list.set(i, list.get(j));
                    list.set(j,temp);
                }
            }
           // System.out.println(i+" ==> i1 + = "+i1+" j= "+j1);
        }
        return list;
    }
    public void sortProduct1(List<WebElement> product){
        List<String> list=new ArrayList<>();
        List<Double> listValue =new ArrayList<>();
        for (int i = 2; i <=product.size()+1 ; i++) {
            WebElement names = Driver.get().findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])["+
                    i+"]//span[@class='a-size-medium a-color-base a-text-normal']"));
            String key = names.getText();
            WebElement prices = null;
            String value;
            try {
                prices = Driver.get().findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])["+
                        i+"]//span[@class='a-price-whole']"));
               value = prices.getText();
            } catch (Exception e) {
                value="0,0";
            }
            String str=value+" : "+key;
            list.add(str);
            listValue.add(Double.parseDouble(value.trim().replace(",",".")));
        }
        Collections.sort(listValue);
        List<String> result=new ArrayList<>();
        for (int j = 0; j < listValue.size() ; j++) {
            Double d = listValue.get(j);
            String s=String.valueOf(d).replace(".",",");
            for (int k = 0; k < listValue.size() ; k++) {
                if(list.get(k).startsWith(s)){
                    result.add(list.get(k));
                    list.set(k,"ok");
                    break;
                }
            }
        }
        for (int i = result.size()-1; i >=0  ; i--) {
            System.out.println(result.get(i));
        }
    }
}
