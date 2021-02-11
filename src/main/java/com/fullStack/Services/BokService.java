package com.fullStack.Services;

import com.fullStack.Repo.BokRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fullStack.Entities.Bok;

@Service

public class BokService {

    @Value("${name:World}")
    private String name;

    @Autowired
    private BokRepo repo;

    public Bok melding(){
        return this.repo.saySomething();
    }
}
