package com.codegym.repository;

import com.codegym.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository // đánh dấu @Repository tự động tiêm interface này vào Spring Container quản lý
public interface ICityRepository extends PagingAndSortingRepository<City, Long> {

}

