package com.csms.service;

import com.csms.model.Sim;
import com.csms.repository.SimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimServiceImpl implements SimService{

    @Autowired
    private SimRepository simRepository;

    @Override
    public void save(Sim sim) {
        simRepository.save(sim);
    }

    @Override
    public List<Sim> getSimByCustomerId(Integer id) {
        return simRepository.findByCustomerId(id);
    }
}
