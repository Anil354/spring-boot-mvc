package com.sathya.springbootmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.springbootmvc.entity.*;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>{

}