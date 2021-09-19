package com.example.springwebmvc.repositories;

import com.example.springwebmvc.models.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {
    private List<Jedi> listJedi;

    public JediRepository() {
        this.listJedi = new ArrayList<>();
    }

    public List<Jedi> getAllJedi(){
        return this.listJedi;
    }

    public void add(final Jedi jedi) {
        this.listJedi.add(jedi);
    }
}
