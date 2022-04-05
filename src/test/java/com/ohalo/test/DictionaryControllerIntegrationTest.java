package com.ohalo.test;

import com.ohalo.data.Dictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
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

    @Test
    //Test for user authentication
    public void testUserAuthFailure() throws Exception {
        ResponseEntity<Dictionary> response = testRestTemplate.withBasicAuth("someuser", "somepassword").
                getForEntity("/ohalo/api/dictionaries/5", Dictionary.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.UNAUTHORIZED);
    }

    @Test
    //Test to get a dictionary
    public void testGetDictionarySuccess() throws Exception {
        ResponseEntity<Dictionary> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity("/ohalo/api/dictionaries/1", Dictionary.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1L, response.getBody().getId());
        Assertions.assertEquals(response.getBody().isIs_case_sensitive(), true);
    }

    @Test
    //Test to get a non existing dictionary 
    public void testGetDictionaryFail() {
        ResponseEntity<String> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity("/ohalo/api/dictionaries/-5", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    //Test to get all dictionaries
    public void testGetDictionariesSuccess() throws Exception {
        ResponseEntity<Dictionary[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity("/ohalo/api/dictionaries", Dictionary[].class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(response);

    }

    @Test
    //Test to get all dictionaries paginated
    public void testGetDictionariesPaginatedSuccess() throws Exception {
        ResponseEntity<Dictionary[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity("/ohalo/api/dictionaries?page=0&size=1", Dictionary[].class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.getBody().length);
    }

    @Test
    //Test to add a new dictionary
    public void testAddDictionary() throws Exception {
        ResponseEntity<Dictionary[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                postForEntity("/ohalo/api/dictionaries/", "", Dictionary[].class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.getBody().length);
    }

//    @Test
//    //Test to add a new dictionary
//    public void testUpdateDictionary() throws Exception {
//        ResponseEntity<Dictionary[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
//                putForEntity("/ohalo/api/dictionaries/", "", Dictionary[].class);
//        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
//        Assertions.assertNotNull(response);
//        Assertions.assertEquals(1, response.getBody().length);
//    }
//
//    @Test
//    //Test to add a new dictionary
//    public void testDeleteDictionary() throws Exception {
//        ResponseEntity<Dictionary[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
//                putForEntity("/ohalo/api/dictionaries/", "", Dictionary[].class);
//        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
//        Assertions.assertNotNull(response);
//        Assertions.assertEquals(1, response.getBody().length);
//    }
//    
//    @Test
//    //Test to add a new dictionary
//    public void testSearchTagetString() throws Exception {
//        ResponseEntity<Dictionary[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
//                putForEntity("/ohalo/api/dictionaries/", "", Dictionary[].class);
//        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
//        Assertions.assertNotNull(response);
//        Assertions.assertEquals(1, response.getBody().length);
//    }

}
