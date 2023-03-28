package com.test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import org.testng.annotations.*;

public class Assignment extends TestBase {

  /*  @Test
    public void AutomationExercise2() throws InterruptedException {
        setUp();
        product();
    }
*/
    @Test
    public void MilesCarrental3() throws InterruptedException {
        setUp();
        setUp3();
        fillI();
        closedBrowser();
    }


}
