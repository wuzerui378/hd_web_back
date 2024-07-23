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

    public void save(List<CustomerDtoList> customerDtoLists) {
        repository.saveAll(customerDtoLists);
    }

    public void update(int id, List<CustomerDtoList> customerDtoLists) {
        for (CustomerDtoList customerDtoList : customerDtoLists) {
            customerDtoList.setId(id); // 或根据需要设置正确的 ID
            repository.save(customerDtoList);
        }
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
