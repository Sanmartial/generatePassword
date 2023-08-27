package com.globaroman.generatepassword.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name ="resource_keydigital" )
public class KeyDigital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "keydigital")
    private int digitKey;

    public KeyDigital(int keydigital) {
        this.digitKey = keydigital;
    }
}
