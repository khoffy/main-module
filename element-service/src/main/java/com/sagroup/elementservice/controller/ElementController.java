package com.sagroup.elementservice.controller;


import com.sagroup.elementservice.Dto.ElementDto;
import com.sagroup.elementservice.service.ElementService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ABDELBIF
 * @version 1.0
 * @created 6-Feb-2023 08:00:00 PM
 */

@RestController
@RequestMapping("/elements")
public class ElementController {
    private ElementService elementService;

    @PostMapping
    public ResponseEntity<?> addElement(@RequestBody ElementDto elementDto){
        return new ResponseEntity<>(elementService.addElement(elementDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewElement(@PathVariable String id){
        ElementDto elementDto = elementService.viewElement(id);
        return new ResponseEntity<>(elementDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateElement(@PathVariable String id, @RequestBody ElementDto elementDto){
        elementService.updateElement(id, elementDto);
        return new ResponseEntity<>(elementDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeElement(@PathVariable String id){
        elementService.removeElement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Autowired
    public void setElementService(ElementService elementService) {
        this.elementService = elementService;
    }
}
