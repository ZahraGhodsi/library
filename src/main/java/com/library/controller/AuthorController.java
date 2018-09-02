package com.library.controller;

import com.library.exceptions.customException;
import com.library.model.AuthorModel;
import com.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {


    @Autowired
    AuthorService service;

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody AuthorModel model){
        try {
            return ResponseEntity.ok(service.add(model));
        } catch (customException e) {
            return ResponseEntity.ok(e);
        } catch (Exception ex) {
            return ResponseEntity.ok(ex);
        }
    }

    @RequestMapping(value = "/batchAdd" , method = RequestMethod.POST)
    public ResponseEntity batchAdd(@RequestBody List<AuthorModel> models){
        try {
            return ResponseEntity.ok(service.batchAdd(models));
        } catch (customException e) {
            return ResponseEntity.ok(e);
        } catch (Exception ex) {
            return ResponseEntity.ok(ex);
    }}

    @RequestMapping(value = "/update" , method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody AuthorModel model){
        try {
            return ResponseEntity.ok(service.update(model));
        } catch (customException e) {
            return ResponseEntity.ok(e);
        } catch (Exception ex) {
            return ResponseEntity.ok(ex);
        }
    }
/*
    @RequestMapping(value = "/getList" , method = RequestMethod.POST)
    public ResponseEntity getList(@RequestBody FilterModel filterModel){
        try {
            return ResponseEntity.ok(service.list(filterModel));
        } catch (customException e) {
            return ResponseEntity.ok(e);
        } catch (Exception ex) {
            return ResponseEntity.ok(ex);
        }
    }*/

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseEntity select(@RequestParam("id") Long id) {
        try {
            return ResponseEntity.ok(service.get(id));
        } catch (customException e) {
            return ResponseEntity.ok(e);
        } catch (Exception ex) {
            return ResponseEntity.ok(ex);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity delete(@RequestParam("id") Long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (customException e) {
            return ResponseEntity.ok(e);
        } catch (Exception ex) {
            return ResponseEntity.ok(ex);
        }
    }
}
