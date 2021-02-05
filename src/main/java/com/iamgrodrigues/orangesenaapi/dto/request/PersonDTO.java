package com.iamgrodrigues.orangesenaapi.dto.request;

import com.iamgrodrigues.orangesenaapi.entity.Bet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Email
    private String email;

    private Set<Bet> bets;
}
