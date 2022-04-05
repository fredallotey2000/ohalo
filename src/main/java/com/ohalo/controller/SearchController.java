/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ohalo.controller;

import com.ohalo.data.Entry;
import com.ohalo.data.SearchRequest;
import com.ohalo.service.DictionaryService;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("ohalo/api/")
public class SearchController {

    private final DictionaryService dictionaryService;

    public SearchController(DictionaryService plantService) {
        this.dictionaryService = plantService;
    }

    //GET method to search a target string using a dictionary id, produces a result of a list of indices per dictionary entry
    @RequestMapping(value = "/search",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity search(
            @RequestParam(value = "dictionaryId", required = true) long dictionaryId,
            @RequestParam(value = "target", required = true) String target
    ) {
        /*CompletableFuture makes async calls to the search method 
        to handle multiple search request concurrently*/
        CompletableFuture<List<Entry>> results = dictionaryService.search(target, dictionaryId);
        try {
            return ResponseEntity.ok().body(results.get());
        } catch (InterruptedException | ExecutionException | CancellationException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    //POST method to search a target string using a dictionary id, produces a result of a list of indices per dictionary entry
    @RequestMapping(value = "/search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity searchPOST(@RequestBody SearchRequest searchRequest) {
        CompletableFuture<List<Entry>> results = dictionaryService.search(searchRequest.getTarget(), searchRequest.getDictionaryId());
        try {
            return ResponseEntity.ok().body(results.get());
        } catch (InterruptedException | ExecutionException | CancellationException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

}
