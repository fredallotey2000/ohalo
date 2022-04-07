package com.ohalo.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    DictionaryControllerIntegrationTest.class,
    OhaloServiceIntegrationTest.class,
    SearchControllerIntegrationTest.class
})

public class OhaloSuiteTest {

    public OhaloSuiteTest() {
    }

  
}
