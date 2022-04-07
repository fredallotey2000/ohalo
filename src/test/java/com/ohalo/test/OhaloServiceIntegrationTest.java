package com.ohalo.test;

import com.ohalo.data.Dictionary;
import com.ohalo.data.Entry;
import com.ohalo.data.Response;
import com.ohalo.service.OhaloService;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class OhaloServiceIntegrationTest {

    @Autowired
    OhaloService dictionaryService;

    @Test
    public void testGetDictionarySuccess() {
        Dictionary dictionary = null;
        dictionary = dictionaryService.getDictionary(1L);
        Assertions.assertNotNull(dictionary);
        Assertions.assertEquals(true, dictionary.isIs_case_sensitive());
    }

    @Test
    public void testGetDictionaryFail() {
        Dictionary dictionary = null;
        dictionary = dictionaryService.getDictionary(100L);
        Assertions.assertNull(dictionary);
    }

    @Test
    public void testGetDictionariesSuccess() {
        List<Dictionary> dictionaries = dictionaryService.getDictionaries();
        Assertions.assertNotNull(dictionaries);
        Assertions.assertEquals(1, dictionaries.size());
    }

    @Test
    public void testGetDictionariesPaginated() {
        List<Dictionary> dictionaries = dictionaryService.getDictionaries(0, 1);
        Assertions.assertNotNull(dictionaries);
        Assertions.assertEquals(1, dictionaries.size());
    }

    @Test
    public void testDeleteDictionarySuccess() {
        Response deletedDictionary = dictionaryService.deleteDictionary(1L);
        Assertions.assertNotNull(deletedDictionary);
        Assertions.assertEquals(true, deletedDictionary.isSuccess());
    }

//    @Test
//    public void testDeleteDictionaryFail() {
//        Response deletedDictionary = dictionaryService.deleteDictionary(10L);
//        Assertions.assertNotNull(deletedDictionary);
//        Assertions.assertEquals(false, deletedDictionary.isSuccess());
//    }

    @Test
    public void testAddDictionarySuccess() {
        Dictionary dictionary = new Dictionary();
        dictionary.setEntries(new String[]{"bo", "o"});
        dictionary.setIs_case_sensitive(false);
        Response newDictionary = dictionaryService.createDictionary(dictionary);
        Assertions.assertNotNull(newDictionary);
        Assertions.assertTrue(Arrays.asList(dictionary.getEntries()).containsAll(Arrays.asList(new String[]{"bo", "o"})));

    }

    @Test
    public void testUpdateDictionarySuccess() {

        Dictionary dictionary = dictionaryService.getDictionary(1L);
        dictionary.setEntries(new String[]{"bo", "th"});
        dictionary.setIs_case_sensitive(false);
        Response deleteDictionary = dictionaryService.createDictionary(dictionary);
        Assertions.assertNotNull(deleteDictionary);
        Arrays.asList(dictionary.getEntries()).containsAll(Arrays.asList(new String[]{"bo", "o"}));
        //Assertions.assertEquals(new String[]{"bo", "th"}, dictionary.getEntries());
        Assertions.assertEquals(false, dictionary.isIs_case_sensitive());
    }

    @Test
    public void testSearchSuccess() throws InterruptedException, ExecutionException {
        Dictionary dictionary = dictionaryService.getDictionary(1L);
        CompletableFuture<List<Entry>> results = dictionaryService.search("The boy is a good boy", dictionary.getId());
        List<Entry> entryResults = results.get();
        Assertions.assertNotNull(entryResults);
        Assertions.assertEquals(2, entryResults.size());
    }

}
