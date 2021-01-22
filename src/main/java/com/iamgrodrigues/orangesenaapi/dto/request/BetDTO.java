package com.iamgrodrigues.orangesenaapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.TreeSet;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BetDTO {

    private Long id;
    private TreeSet<Integer> numbers = new TreeSet<>();
    private Instant moment;
}
