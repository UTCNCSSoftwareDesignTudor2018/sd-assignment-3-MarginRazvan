package com.NewsAgency.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NewsAgency.persistence.entity.Writer;

public interface WriterRepository extends JpaRepository<Writer, Integer> {

}
