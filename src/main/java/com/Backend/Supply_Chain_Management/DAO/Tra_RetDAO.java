package com.Backend.Supply_Chain_Management.DAO;

import com.Backend.Supply_Chain_Management.Model.CompositeKey.TraRetIdentity;
import com.Backend.Supply_Chain_Management.Model.Tra_Ret;
import com.Backend.Supply_Chain_Management.Util.UserInter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Tra_RetDAO extends JpaRepository<Tra_Ret, TraRetIdentity> {

    @Query("select t_r from Tra_Ret t_r where t_r.traRetIdentity.name=:n " +
            "and t_r.traRetIdentity.location=:l")
    List<Tra_Ret> findByNameAndLocation(@Param("n") String name, @Param("l") String Location);

    @Query("select t_r from Tra_Ret t_r where t_r.id=:i")
    Tra_Ret findByUniqueId( @Param("i") String id);

    @Query("select t_r from Tra_Ret t_r where t_r.id like 'tra%'")
    List<UserInter> getAllTransporter();

    @Query("select t_r from Tra_Ret t_r where t_r.id like 'ret%'")
    List<UserInter> getAllRetailer();
}
