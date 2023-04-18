package com.sagroup.userservice.service;

import com.sagroup.userservice.dtos.NewAppUserDto;
import com.sagroup.userservice.entity.NewAppUser;
import com.sagroup.userservice.repository.NewAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewAppUserService {

    private NewAppUserRepository userRepository;

    private SendEmail sendEmail;

    public List<NewAppUser> viewAll() {
        return userRepository.findAll();
    }

    public NewAppUser update(NewAppUserDto userDto) {
        NewAppUser userToBeUpdated = userRepository.findById(userDto.getId()).get();
        userToBeUpdated.setUsername(userDto.getUsername());
        userToBeUpdated.setPassword(userDto.getPassword());
        return userRepository.save(userToBeUpdated);
    }
    public NewAppUser save(NewAppUserDto userDto) {
        NewAppUser user = new NewAppUser();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        NewAppUser userCreated = userRepository.save(user);
        sendEmail.sendMail(user.getUsername());
        return userCreated;
    }

    public void removeById(String id) {
        userRepository.deleteById(id);
    }

    @Autowired
    public void setUserRepository(NewAppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setSendEmail(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }
}
