package com.example.DBRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface billpayeeRepository extends JpaRepository<billpayee, String> {
}
