package com.Backend.Supply_Chain_Management.DAO;

import com.Backend.Supply_Chain_Management.Model.Admin;
import com.Backend.Supply_Chain_Management.Util.UserInter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminDAO extends JpaRepository<Admin, String> {

    List<Admin> findByName(String name);

    @Query("select ad from Admin ad where ad.id=:a")
    Admin findByUniqueId( @Param("a") String id);

    @Query("select ad from Admin ad")
    List<UserInter> getAllAdmin();
}
