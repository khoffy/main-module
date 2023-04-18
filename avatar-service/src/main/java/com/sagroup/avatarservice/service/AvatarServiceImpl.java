package com.sagroup.avatarservice.service;

import com.sagroup.avatarservice.entity.Avatar;
import com.sagroup.avatarservice.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvatarServiceImpl implements AvatarService{

    @Autowired
    private AvatarRepository avatarRepository;

    @Override
    public List<Avatar> viewAll() {
        return avatarRepository.findAll();
    }

    @Override
    public void update(long id, Avatar avatar) {
        Avatar avatarToBeUpdated =avatarRepository.findById(id).get();
        avatarToBeUpdated.setBody(avatar.getBody());
        avatarToBeUpdated.setHair(avatar.getHair());
        avatarToBeUpdated.setEar(avatar.getEar());
        avatarToBeUpdated.setHat(avatar.getHat());
        avatarToBeUpdated.setEye(avatar.getEye());
        avatarToBeUpdated.setHead(avatar.getHead());
        avatarToBeUpdated.setEyeBrow(avatar.getEyeBrow());
        avatarToBeUpdated.setMouth(avatar.getMouth());
        avatarToBeUpdated.setNose(avatar.getNose());
        avatarToBeUpdated.setHatColor(avatar.getHatColor());
        avatarToBeUpdated.setTopColor(avatar.getTopColor());
        avatarToBeUpdated.setHairColor(avatar.getHairColor());
        avatarRepository.save(avatarToBeUpdated);
    }

    @Override
    public void save(Avatar avatar) {
        avatarRepository.save(avatar);
    }

    @Override
    public void removeById(long id) {
        avatarRepository.deleteById(id);
    }
}
