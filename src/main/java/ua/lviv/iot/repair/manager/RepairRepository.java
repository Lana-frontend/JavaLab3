package ua.lviv.iot.repair.manager;

import org.springframework.data.repository.CrudRepository;

import ua.lviv.iot.repair.model.Fix;
import ua.lviv.iot.repair.model.Hammer;

public interface RepairRepository extends CrudRepository<Hammer, Integer> {

    
   
    
}