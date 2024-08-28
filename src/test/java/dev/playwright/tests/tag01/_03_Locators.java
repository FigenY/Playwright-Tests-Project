package dev.playwright.tests.tag01;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

public class _03_Locators extends TestBase {

    @Test
    public void test1() throws InterruptedException {

        page.navigate("https://www.kitapyurdu.com/");

        //getByText
        Locator cartEmpty = page.getByText("Sepetiniz boş");
        System.out.println("cartEmpty.innerText() = " + cartEmpty.innerText());

        //h5[text()='Sepetiniz boş']

        //getByRole
        Locator searchBoxByRole = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("kitap adı, yazar veya yayınevi ara"));
        searchBoxByRole.fill("java");
        System.out.println("searchBoxByRole.innerText() = " + searchBoxByRole.inputValue());
        System.out.println("searchBoxByRole.getAttribute(\"name\") = " + searchBoxByRole.getAttribute("name"));
        Thread.sleep(2000);

        //getByPlaceholder
        Locator searchBoxByPlaceholder = page.getByPlaceholder("kitap adı, yazar veya yayınevi ara");

        searchBoxByPlaceholder.clear();

        searchBoxByPlaceholder.pressSequentially("Monte Kristo Kontu", new Locator.PressSequentiallyOptions().setDelay(300));

        searchBoxByPlaceholder.clear();

        //getByLabel
        Locator slide8ByLabel = page.getByLabel("Go to slide 8").last();

        slide8ByLabel.click();
    }

    @Test
    public void test2() throws InterruptedException {
       page.navigate("https://www.kitapyurdu.com/");


        //getByLabel
//        Locator slide8ByLabel = page.getByLabel("Go to slide 8").last();
//
//        slide8ByLabel.click();
//
//        Thread.sleep(2000);

        Locator kitapYurdu = page.getByAltText("kitapyurdu.com").last();

        kitapYurdu.click();
        Thread.sleep(2000);


    }

    @Test
    public void test3() throws InterruptedException {
        page.navigate("https://www.yemeksepeti.com/");

        Locator textBoxByPlaceholder = page.getByPlaceholder("Örneğin: Esentepe Dede Korkut Sk. No:28/1");

        textBoxByPlaceholder.fill("istanbul");


        Locator kesfetByTestId = page.getByTestId("homepage_cta");

        kesfetByTestId.click();
        Thread.sleep(2000);
    }

    @Test
    public void test4() throws InterruptedException {
        page.navigate("https://www.idefix.com/");
        Locator elektronikByFilter = page.locator("a.text-center").filter(new Locator.FilterOptions().setHasText("Elektronik"));

        elektronikByFilter.click();


        Thread.sleep(2000);


    }
}
