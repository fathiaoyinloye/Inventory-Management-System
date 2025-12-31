package com.inventorymanagementsytem.demo.data.repositories;

import com.inventorymanagementsytem.demo.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
