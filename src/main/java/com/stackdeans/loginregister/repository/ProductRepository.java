package com.stackdeans.loginregister.repository;

import com.stackdeans.loginregister.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Ghonim
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    //   @Query(value = "SELECT p FROM Product WHERE p.name = :name")
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    List<Product> search(@Param("name") String name);

    @Query("SELECT p FROM Product p ORDER BY p.noOfSellings")
    List<Product> searchForTop();


}


//@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
//        + " OR p.brand LIKE %?1%"
//        + " OR p.madein LIKE %?1%"
//        + " OR CONCAT(p.price, '') LIKE %?1%")