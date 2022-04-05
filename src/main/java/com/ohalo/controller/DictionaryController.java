/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ohalo.controller;

import com.ohalo.data.Dictionary;
import com.ohalo.data.Response;
import com.ohalo.service.DictionaryService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bsystems4
 */
@RestController
@RequestMapping("ohalo/api/dictionaries")

public class DictionaryController {

    private final DictionaryService dictionaryService;

    public DictionaryController(DictionaryService plantService) {
        this.dictionaryService = plantService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})

    @ResponseBody
    //Paginated method to get all dictionaries
    public ResponseEntity getDictionaries(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size
    ) {
        if (page == null || size == null) {
            List<Dictionary> dictionaries = dictionaryService.getDictionaries();
            return ResponseEntity.ok().body(dictionaries);
        } else {
            List<Dictionary> dictionaries = dictionaryService.getDictionaries(page, size);
            return ResponseEntity.ok().body(dictionaries);
        }
    }

    @RequestMapping(value = "{dictionaryId}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //Method to retrieve dictionary using the dictionary id
    public ResponseEntity getDictionary(@PathVariable Long dictionaryId) {
        Dictionary dictionary = dictionaryService.getDictionary(dictionaryId);
        if (dictionary == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No dictionary found with Id " + dictionaryId);
        } else {
            return ResponseEntity.ok().body(dictionary);
        }
    }

    @RequestMapping(value = "{dictionaryId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //Method to delete dictionary entry using the dictionary id
    public ResponseEntity deleteDictionary(@PathVariable Long dictionaryId) {
        Response response = dictionaryService.deleteDictionary(dictionaryId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //Method to add a new dictionary entry
    public ResponseEntity createDictionary(@RequestBody Dictionary dictionary) {
        Response response = dictionaryService.createDictionary(dictionary);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //Method to update an existing dictionary entry
    public ResponseEntity updateDictionary(@RequestBody Dictionary dictionary) {
        Response response = dictionaryService.updateDictionary(dictionary);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
