package com.ohalo.test;

import com.ohalo.data.Dictionary;
import com.ohalo.data.EntityModel;
import com.ohalo.data.Response;
import java.util.Arrays;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class DictionaryControllerIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    final String dictionaryURL = "/ohalo/api/dictionaries";

    @Test
    //Test for user authentication
    public void testUserAuthFailure()  {
        ResponseEntity<Dictionary> response = testRestTemplate.withBasicAuth("someuser", "somepassword").
                getForEntity(dictionaryURL + "/5", Dictionary.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.UNAUTHORIZED);
    }

    @Test
    //Test to get a dictionary
    public void testGetDictionarySuccess()  {
        ResponseEntity<Dictionary> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity(dictionaryURL + "/1", Dictionary.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1L, response.getBody().getId());
        Assertions.assertEquals(response.getBody().isIs_case_sensitive(), true);
    }

    @Test
    //Test to get a non existing dictionary 
    public void testGetDictionaryFail() {
        ResponseEntity<String> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity(dictionaryURL + "/-5", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    //Test to get all dictionaries
    public void testGetDictionariesSuccess()  {
        ResponseEntity<Dictionary[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity(dictionaryURL, Dictionary[].class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(response);

    }

    @Test
    //Test to get all dictionaries paginated
    public void testGetDictionariesPaginatedSuccess()  {
        ResponseEntity<Dictionary[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity(dictionaryURL + "?page=0&size=1", Dictionary[].class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.getBody().length);
    }

    @Test
    //Test to add a new dictionary
    public void testAddDictionary() {

        Dictionary dictionary = new Dictionary();
        dictionary.setEntries(new String[]{"boo", "is"});
        dictionary.setIs_case_sensitive(true);
        ResponseEntity<Response> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                postForEntity(dictionaryURL, dictionary, Response.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody().getData());
        Assertions.assertTrue(response.getBody().isSuccess());
    }

//    @Test
//    //Test allowed HTTP methods
//    public void testAllowedOperations()  {
//
//        Set<HttpMethod> optionsForAllow = testRestTemplate.optionsForAllow(dictionaryURL);
//        HttpMethod[] supportedMethods
//                = {HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
//        Assertions.assertTrue(optionsForAllow.containsAll(Arrays.asList(supportedMethods)));
//    }

    @Test
    //Test to add a new dictionary
    public void testUpdateDictionary()  {

        Dictionary dictionary = new Dictionary();
        dictionary.setId(1L);
        dictionary.setEntries(new String[]{"boo", "is"});
        dictionary.setIs_case_sensitive(true);
        testRestTemplate.withBasicAuth("gentest", "genTest123$").
                put(dictionaryURL, dictionary);
    }

    @Test
    //Test to add a new dictionary
    public void testDeleteDictionary()  {
        testRestTemplate.withBasicAuth("gentest", "genTest123$").
                delete(dictionaryURL + "1");
    }

}
