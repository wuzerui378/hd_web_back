package org.area.service;

import org.area.dao.CustomerDtoListRepository;
import org.area.model.CustomerDtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerDtoListService {
    @Autowired
    private CustomerDtoListRepository repository;


    public List<CustomerDtoList> getAllCustomerDtoLists() {
        return repository.findAll();
    }

    public List<CustomerDtoList> getAll() {
        return repository.findAll();
    }

    public CustomerDtoList getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<CustomerDtoList> getByRegionClusterId(int regionClusterId) {
        return repository.findByRegionClusterId(regionClusterId);
    }

    public CustomerDtoList save(CustomerDtoList customerDtoList) {
        return repository.save(customerDtoList);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
