package org.launchcode.mallfinder.models.data;

import org.launchcode.mallfinder.models.Mall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface MallDao extends CrudRepository<Mall,Integer> {
    Iterable<Mall> findByMallAddressZip(Integer zip);
    Iterable<Mall> findByMallAddressCityAndMallAddressState(String city, String state);
}
