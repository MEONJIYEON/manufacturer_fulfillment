package com.ot.man.manufacturer.data.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.ot.man.manufacturer.data.entity.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    //Optional<Manufacturer>findByOutPName(String out_pname);
}
