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


    public CustomerDtoList getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<CustomerDtoList> getByRegionClusterId(int regionClusterId) {
        return repository.findByRegionClusterId(regionClusterId);
    }

    public void saveAll(List<CustomerDtoList> customerDtoLists) {
        repository.saveAll(customerDtoLists);
    }

    public void updateAll(int id, List<CustomerDtoList> customerDtoLists) {
        for (CustomerDtoList customerDtoList : customerDtoLists) {
            customerDtoList.setRegionClusterId(id); // 假设有这个字段
            repository.save(customerDtoList);
        }
    }

    public void deleteByRegionClusterId(int regionClusterId) {
        repository.deleteByRegionClusterId(regionClusterId);
    }
}
