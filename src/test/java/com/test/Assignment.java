package com.test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import org.testng.annotations.*;

public class Assignment extends TestBase {

    @Test
    public void createContact() {
        setUp();
        NewContact contact = new NewContact(driver);
        contact.newContact();

    }

    @Test
    public void createCustomer() {
        setUp();
        NewCustomer customer = new NewCustomer(driver);
        customer.createCustomer();
        closedBrowser();
    }

}
