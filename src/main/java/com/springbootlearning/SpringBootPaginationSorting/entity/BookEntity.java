package com.springbootlearning.SpringBootPaginationSorting.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "book_name")
    private String bookname;
}
