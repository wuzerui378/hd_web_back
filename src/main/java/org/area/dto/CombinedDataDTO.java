package org.area.dto;
import org.area.model.AreaList;
import org.area.model.CustomerDtoList;
import org.area.model.RegionClusterSubmit;

import java.util.Collections;
import java.util.List;

public class CombinedDataDTO {
    private List<RegionClusterSubmit> regionClusterSubmits;
    private List<AreaList> areaLists;
    private List<CustomerDtoList> customerDtoLists;

    // 构造函数，接受列表
    public CombinedDataDTO(List<RegionClusterSubmit> regionClusterSubmits,
                           List<AreaList> areaLists,
                           List<CustomerDtoList> customerDtoLists) {
        this.regionClusterSubmits = regionClusterSubmits;
        this.areaLists = areaLists;
        this.customerDtoLists = customerDtoLists;
    }

    // 构造函数，接受单个 RegionClusterSubmit 实例
    public CombinedDataDTO(RegionClusterSubmit regionClusterSubmit,
                           List<AreaList> areaLists,
                           List<CustomerDtoList> customerDtoLists) {
        this.regionClusterSubmits = Collections.singletonList(regionClusterSubmit); // 将单个对象包装成列表
        this.areaLists = areaLists;
        this.customerDtoLists = customerDtoLists;
    }

    // Getter 和 Setter 方法
    public List<RegionClusterSubmit> getRegionClusterSubmits() {
        return regionClusterSubmits;
    }

    public void setRegionClusterSubmits(List<RegionClusterSubmit> regionClusterSubmits) {
        this.regionClusterSubmits = regionClusterSubmits;
    }

    public List<AreaList> getAreaLists() {
        return areaLists;
    }

    public void setAreaLists(List<AreaList> areaLists) {
        this.areaLists = areaLists;
    }

    public List<CustomerDtoList> getCustomerDtoLists() {
        return customerDtoLists;
    }

    public void setCustomerDtoLists(List<CustomerDtoList> customerDtoLists) {
        this.customerDtoLists = customerDtoLists;
    }
}
