package com.nhom6.mxh.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom6.mxh.Models.test;

public interface TestRepository extends JpaRepository<test, Long>{

    List<test> findByLastNameOrFirstName(String lastName, String firstName);

}
