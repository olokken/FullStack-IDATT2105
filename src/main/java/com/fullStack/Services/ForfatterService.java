package com.fullStack.Services;

import com.fullStack.Repo.ForfatterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fullStack.Entities.Forfatter;

@Service
public class ForfatterService {

    @Value("${name:World}")
    private String name;

    @Autowired
    private ForfatterRepo repo;

    public Forfatter melding(){
        return this.repo.saySomething();
    }
}
