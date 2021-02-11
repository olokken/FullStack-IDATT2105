package com.fullStack.Repo;


import com.fullStack.Entities.Forfatter;
import org.springframework.stereotype.Repository;


@Repository
public class ForfatterRepo {

    public Forfatter saySomething() {

        return new Forfatter();
    }
}
