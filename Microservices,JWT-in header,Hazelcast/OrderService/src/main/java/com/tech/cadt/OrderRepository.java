package com.tech.cadt;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tech.cadt.order.entity.OrderProduct;
@Transactional
public interface OrderRepository extends CrudRepository<OrderProduct, Integer> {
	public List<OrderProduct> findByCustomerId(long customerId);

}
