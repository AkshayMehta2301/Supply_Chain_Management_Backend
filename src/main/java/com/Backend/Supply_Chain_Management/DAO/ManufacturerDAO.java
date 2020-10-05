package com.Backend.Supply_Chain_Management.DAO;

import com.Backend.Supply_Chain_Management.Model.CompositeKey.ManufacturerIdentity;
import com.Backend.Supply_Chain_Management.Model.Manufacturer;
import com.Backend.Supply_Chain_Management.Util.UserInter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerDAO extends JpaRepository<Manufacturer, ManufacturerIdentity> {

    @Query("select m from Manufacturer m where m.manufacturerIdentity.name=:n " +
            "and m.manufacturerIdentity.location=:l and m.manufacturerIdentity.component=:c")
    List<Manufacturer> findByNameAndLocationAndComponent(@Param("n") String name,
                                                         @Param("l") String location, @Param("c") String component);

    @Query("select man from Manufacturer man where man.id=:i")
    Manufacturer findByUniqueId(@Param("i") String id);

    @Query("select man from Manufacturer man")
    List<UserInter> getAllManufacturer();
}
