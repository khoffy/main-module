package com.sagroup.avatarservice.service;

import com.sagroup.avatarservice.entity.Avatar;

import java.util.List;

public interface AvatarService {

    List<Avatar> viewAll();
    void update(long id,Avatar avatar);
    void save(Avatar avatar);
    void removeById(long id);
}
