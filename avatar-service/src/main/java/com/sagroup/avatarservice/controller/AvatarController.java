package com.sagroup.avatarservice.controller;

import com.sagroup.avatarservice.entity.Avatar;
import com.sagroup.avatarservice.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avatars")
public class AvatarController {
    @Autowired
    private AvatarService avatarService;
    @GetMapping("/view")
    public List<Avatar> viewAll(){
        return avatarService.viewAll();
    }
    @PostMapping("/save")
    public void save(@RequestBody Avatar avatar){
        avatarService.save(avatar);
    }
    @PutMapping("/update/{id}")
    public void update(@PathVariable long id,@RequestBody Avatar avatar){
        avatarService.update(id, avatar);
    }
    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable long id){
        avatarService.removeById(id);
    }
}
