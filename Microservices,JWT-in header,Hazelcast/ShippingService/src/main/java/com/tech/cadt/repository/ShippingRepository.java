package com.tech.cadt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tech.cadt.entity.Shipping;
@Transactional
public interface ShippingRepository extends CrudRepository<Shipping, Integer>{
public Shipping findByOrderId(long orderId);
}
