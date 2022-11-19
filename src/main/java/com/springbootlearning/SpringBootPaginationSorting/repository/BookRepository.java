package com.springbootlearning.SpringBootPaginationSorting.repository;

import com.springbootlearning.SpringBootPaginationSorting.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
