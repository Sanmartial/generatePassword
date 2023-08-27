package com.globaroman.generatepassword.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name ="resource_keyword" )
@Entity
public class KeyWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name ="keyword" )
    private String nameKeyword;

    public KeyWord(String keyword) {
        this.nameKeyword = keyword;
    }
}
