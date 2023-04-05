package com.spring.home_work.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;
    String title;
    String content;
}
