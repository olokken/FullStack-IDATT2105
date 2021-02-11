package com.fullStack.Repo;


import com.fullStack.Entities.Bok;
import org.springframework.stereotype.Repository;


@Repository
public class BokRepo {

    public Bok saySomething() {
        return new Bok();
    }

    public Bok nyBok(Bok bok) {
        return bok;
    }
}
