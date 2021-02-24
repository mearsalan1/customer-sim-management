package com.csms.service;

import com.csms.model.Sim;

import java.util.List;

public interface SimService {
    void save(Sim sim);

    List<Sim> getSimByCustomerId(Integer id);
}
