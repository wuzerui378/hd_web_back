package org.area.service;

import jakarta.transaction.Transactional;
import org.area.dao.CustomerDtoListRepository;
import org.area.model.CustomerDtoList;
import org.area.vo.request.RegionClusterCustomerPageRequest;
import org.area.vo.response.RegionClusterCustomerPageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional  // 确保所有方法都在事务中执行
public class CustomerDtoListService {
    @Autowired
    private CustomerDtoListRepository repository;

    public List<CustomerDtoList> getAllCustomers() {
        return repository.findAll();
    }

    public CustomerDtoList getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public CustomerDtoList save(CustomerDtoList customer) {
        return repository.save(customer);
    }

    public void update(int id, CustomerDtoList customer) {
        customer.setId(id);
        repository.save(customer);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }


}
