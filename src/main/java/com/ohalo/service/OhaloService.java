/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ohalo.service;

import com.ohalo.data.Dictionary;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.ohalo.data.DictionaryRepository;
import com.ohalo.data.Entry;
import com.ohalo.data.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

/**
 *
 * @author Bsystems4
 */
@EnableCaching
@CacheConfig(cacheNames = "dictionary")
@Service
public class OhaloService {

    private final DictionaryRepository dictionaryRepository;

    public OhaloService(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Cacheable
    //Method to get a dictionary
    public Dictionary getDictionary(long id) {
        Dictionary dictionary = null;
        try {
            dictionary = dictionaryRepository.findById(id).get();
        } catch (java.util.NoSuchElementException ex) {
        }
        return dictionary;
    }

    //Method to delete a dictionary
    public Response deleteDictionary(long id) {
        Response response = Response.deleteSuccess;
        response.setRecordId(id);
        try {
            dictionaryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            response.setMessage("No dictionary found with Id " + id + " exists");
            response.setSuccess(false);
        }
        return response;
    }

    @Cacheable
    //Method to get all dictionaries
    public List<Dictionary> getDictionaries() {
        List<Dictionary> dictionaries = dictionaryRepository.findAll();
        return dictionaries;
    }

    @Cacheable
    //Paginated method to get all dictionaries
    public List<Dictionary> getDictionaries(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        List<Dictionary> dictionaries = dictionaryRepository.findAll(paging).toList();
        return dictionaries;
    }

    //Method to add a new dictionary
    public Response createDictionary(Dictionary dictionary) {
        Dictionary newDictionary = dictionaryRepository.save(dictionary);
        Response response = Response.createSuccess;
        response.setEntity("Dictionary");
        response.setData(newDictionary);
        return response;
    }

    //Method to upadate a dictionary
    public Response updateDictionary(Dictionary dictionary) {
        Response response = Response.updateSuccess;
        response.setEntity("Dictionary");
        try {
            Dictionary updateDictionary = dictionaryRepository.save(dictionary);
            response.setData(updateDictionary);
        } catch (java.util.NoSuchElementException ex) {
            response.setSuccess(false);
            response.setMessage("No dictionary found with Id " + dictionary.getId());
        }
        return response;
    }

    @Async
    //Asyncronous method to search a target string with dictionary entries
    public CompletableFuture<List<Entry>> search(String target, long dictionaryId) {
        List<Entry> results = new ArrayList<>();
        Dictionary dictionary = getDictionary(dictionaryId);
        if (dictionary == null) {
            return CompletableFuture.completedFuture(results);
        }
        String[] split = dictionary.getEntriesStr().split(";");
        boolean is_case_sensitive = dictionary.isIs_case_sensitive();
        for (String dictionaryEntry : split) {
            List<int[]> findWordUpgrade = SearchUtil.searchTarget(target, dictionaryEntry, is_case_sensitive);
            Entry entry = new Entry(dictionaryEntry, findWordUpgrade);
            results.add(entry);
        }
        return CompletableFuture.completedFuture(results);
    }

}
