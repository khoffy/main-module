package com.sagroup.userservice.controller;

import com.sagroup.userservice.dtos.NewAppUserDto;
import com.sagroup.userservice.entity.NewAppUser;
import com.sagroup.userservice.service.NewAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class NewAppUserController {

    private NewAppUserService userService;
    @GetMapping("/view")
    public List<NewAppUser> viewAll(){
        return userService.viewAll();
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody NewAppUserDto userDto){
        NewAppUser user = userService.save(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody NewAppUserDto userDto){
        NewAppUser user = userService.update(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable String id){
        userService.removeById(id);
    }

    @Autowired
    public void setUserService(NewAppUserService userService) {
        this.userService = userService;
    }
}
