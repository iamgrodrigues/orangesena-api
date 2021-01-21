package com.iamgrodrigues.orangesenaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.TreeSet;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private TreeSet<Integer> numbers = new TreeSet<>();

    @Column(nullable = false)
    private Instant moment;
}
