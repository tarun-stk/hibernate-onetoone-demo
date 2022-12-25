package com.onetoone.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetoone.mapping.entity.Instructor;

public interface InstructorRepositosity extends JpaRepository<Instructor, Integer> {

}
