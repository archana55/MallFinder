package org.launchcode.mallfinder.models.data;

import org.launchcode.mallfinder.models.Mall;
import org.launchcode.mallfinder.models.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StoreDao extends CrudRepository<Store,Integer> {
}
