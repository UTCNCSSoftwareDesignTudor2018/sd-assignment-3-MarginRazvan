package com.NewsAgency.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NewsAgency.persistence.entity.Writer;


public interface WriterRepository extends JpaRepository<Writer, Integer> {
	
	public Writer findByEmail(String email);

}
