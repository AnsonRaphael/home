package com.nanos.home.dataservice.repository;

import com.nanos.home.dataservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
