package com.example.sp_lab5.uvt.persistence;

import com.example.sp_lab5.uvt.books.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {
}
