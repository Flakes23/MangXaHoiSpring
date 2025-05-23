package com.nhom6.mxh.Repository.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nhom6.mxh.Models.User.User;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);

  @Query("SELECT u FROM User u LEFT JOIN FETCH u.userAbouts WHERE u.id = :id")
  User findByUserWithUserAbouts(@Param("id") Long user);

  @Query(value = "SELECT MAX(id_user) FROM user", nativeQuery = true)
  Integer countById();

  @Modifying
  @Transactional
  @Query("UPDATE User u SET u.isActive = false WHERE u.isActive = true")
  void updateActiveUserToFalse();

  // Lỗi truy vấn LIKE
  @Query(value = "SELECT u FROM User u WHERE u.lastName LIKE %:name% OR u.firstName LIKE %:name%")
  List<User> findAllByFirstNameOrLastName(@Param("name") String name);

  List<User> findByLastNameOrFirstName(String firstName, String lastName);

  @Query("SELECT u FROM User u WHERE u.lastName LIKE CONCAT('%', :name, '%') ESCAPE '|' OR u.firstName LIKE CONCAT('%', :name, '%') ESCAPE '|'")
  List<User> searchUser(String name);

}
