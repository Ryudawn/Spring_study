package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNo;

    @ManyToOne
    private Board board; //외래키
    
    @Column(length = 1500)
    private String content;
    
    @ManyToOne
    private Member writer; //외래키

}
