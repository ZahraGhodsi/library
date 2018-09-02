/*
package com.library.controller;

import com.library.model.MemberModel;
import com.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    JPresent jPresent;

    @Autowired
    MemberService service;

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public ResponseEntity<JPresent> add(@RequestBody MemberModel model){
        try {
            return jPresent.getResponse(new JDataModel(service.add(model)));
        } catch (customException e) {
            return jPresent.getResponse(e);
        } catch (Exception ex) {
            return jPresent.getResponse(ex);
        }
    }

    @RequestMapping(value = "/batchAdd" , method = RequestMethod.POST)
    public ResponseEntity<JPresent> batchAdd(@RequestBody List<MemberModel> models){
        try {
            return jPresent.getResponse(new JDataModel(service.batchAdd(models)));
        } catch (customException e) {
            return jPresent.getResponse(e);
        } catch (Exception ex) {
            return jPresent.getResponse(ex);
        }
    }

    @RequestMapping(value = "/update" , method = RequestMethod.POST)
    public ResponseEntity<JPresent> update(@RequestBody MemberModel model){
        try {
            return jPresent.getResponse(new JDataModel(service.update(model)));
        } catch (customException e) {
            return jPresent.getResponse(e);
        } catch (Exception ex) {
            return jPresent.getResponse(ex);
        }
    }

    @RequestMapping(value = "/getList" , method = RequestMethod.POST)
    public ResponseEntity<JPresent> getList(@RequestBody FilterModel filterModel){
        try {
            return jPresent.getResponse(new JDataModel(service.list(filterModel)));
        } catch (customException e) {
            return jPresent.getResponse(e);
        } catch (Exception ex) {
            return jPresent.getResponse(ex);
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseEntity<JPresent> select(@RequestParam("id") Long id) {
        try {
            return jPresent.getResponse(new JDataModel(service.get(id)));
        } catch (customException sx) {
            return jPresent.getResponse(sx);
        } catch (Exception ex) {
            return jPresent.getResponse(ex);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<JPresent<Boolean>> delete(@RequestParam("id") Long id) {
        try {
            return jPresent.getResponse(new JDataModel(service.delete(id)));
        } catch (customException sx) {
            return jPresent.getResponse(sx);
        } catch (Exception ex) {
            return jPresent.getResponse(ex);
        }
    }
}
*/
