package com.ali.ecommerce.repository;


import com.ali.ecommerce.model.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {



//    methods with functionalities based on its name structure:

//    boolean existsByName(String categoryName);


//    public EntityClass1 method1(ClassName2 obj2);
//
//    public Optional<EntityClass1> method2(ClassName3 obj3);
//
//    public List<EntityClass1> method3(ClassName4 obj4);
//
//    Page<Product> findAllByName(Pageable pageable);
//    //    wrapping Page inside Optional is unnecessary, because page can never be null

    List<Cart> findAllByUserEmail(String userEmail);

    boolean existsByUserEmail(String userEmail);

//    void deleteAllByUserEmail(String email);
//    the above is wrong

    Cart findByCartItems_Id(Long cartItemId);

//    JPQL queries:

    @Modifying
    @Transactional
    @Query("DELETE FROM Cart c WHERE c.user.email = :email")
    void deleteAllByUserEmail(@Param("email") String email);



//    native SQL queries: methods with functionalities based on the SQL query specified in the annotation:

//    @Query(value = "SELECT * FROM table_name", nativeQuery = true)
//    public List<EntityClass1> method4();
//
//    @Query(
//            value = "",
//            nativeQuery = true
//    )
//    Page<Product> method1();
//    //    wrapping Page inside Optional is unnecessary, because page can never be null


//    ---------------------------------------------------------------------------

//    @Query(
//            value = "insert into category_names (name) values (:categoryName)",
//            nativeQuery = true
//    )
//    @Modifying
//    void method2(String categoryName);
//
//
//
//    @Modifying
//    @Transactional
//    //    @Transactional is needed if the method is an updating method
//    @Query("UPDATE User u SET u.email = :email WHERE u.id = :id")
//    void updateEmailById(@Param("id") Long id, @Param("email") String email);
//
//
//
//
//    @Procedure(name = "procedureName1")
//        //    or
//        //@Query(
//        //        value = "CALL procedureName1()",
//        //        nativeQuery = true
//        //)
//    void executeStoredProcedure1();
//
//
//    @Query(
//            value = "",
//            nativeQuery = true
//    )
//    @Modifying
//    void changingDataMethod1();


//    ---------------------------------------------------------------------------


//  - stored procedures, functions, triggers, views, ... must be created in the database and not here.
//  - in case you need to execute a complex SQL query that results in a table which is not mapped to
//    any entity class, then don't use spring data JPA and use instead either EntityManager or JdbcTemplate.
//    also, when the query is applied on a table that is not an entity class like a temporary table, ... then it is
//    better to either use EntityManager or JdbcTemplate
}
