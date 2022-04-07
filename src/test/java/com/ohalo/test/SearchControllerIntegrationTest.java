package com.ohalo.test;

import com.ohalo.data.Entry;
import com.ohalo.data.SearchRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class SearchControllerIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    final String searchURL = "/ohalo/api/search";

    @Test
    //Test for search GET method
    public void testSearchGET() {
        Entry[] results = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForObject(searchURL + "?dictionaryId=1&target=The boy is a good boy", Entry[].class);
        Assertions.assertNotNull(results);
        Assertions.assertEquals(2L, results.length);
//        Assertions.assertTrue(results[0].getIndices().containsAll(new int[]{4, 5}));
    }

    @Test
    //Test for search POST method
    public void testSearchPOST() {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setDictionaryId(1L);
        searchRequest.setTarget("The boy is a good boy");
        Entry[] results = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                postForObject(searchURL, searchRequest, Entry[].class);
        Assertions.assertNotNull(results);
        Assertions.assertEquals(2L, results.length);
//        Assertions.assertTrue(results[0].getIndices().containsAll(new int[]{4, 5}));
    }
}
