/*
package com.library.controller;

import com.library.exceptions.customException;
import com.library.service.BookFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

*/
/**
 * Created by Ahangari on 08/22/2017.
 *//*

@RestController
@RequestMapping(value = "/bookFile")
public class BookFileController {

    @Autowired
    JPresent jPresent;

    @Autowired
    BookFileService service;

    @RequestMapping(value = "/upload" , method = RequestMethod.POST , produces = "application/json" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<JPresent> upload(@RequestParam MultipartFile file) throws Exception {

        try {
            return jPresent.getResponse(new JDataModel(service.add(file)));
        }
        catch (customException e) {
            return jPresent.getResponse(e);

        }   catch (Exception ex) {
          return jPresent.getResponse(ex);
        }
}

*/
/*    @RequestMapping(value = "/update" , method = RequestMethod.POST, produces = "application/json" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<JPresent> update(@RequestParam("id") Long id , @RequestParam MultipartFile file){
        try {
            return jPresent.getResponse(new JDataModel(service.update(id,file)));
        } catch (customException e) {
            return jPresent.getResponse(e);
        } catch (Exception ex) {
            return jPresent.getResponse(ex);
        }
    }*//*


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
    public ResponseEntity<JPresent> get(@RequestParam("id") Long id , HttpServletResponse response) {
        try {
            BookFileModel file = service.get(id);
            response.setContentType(file.getType());
            response.setContentLength(file.getData().length);
            response.setHeader("Content-Disposition","attachment; filename=\"" + file.getName() +"\"");

            FileCopyUtils.copy(file.getData(), response.getOutputStream());

            return jPresent.getResponse(new JDataModel());
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
