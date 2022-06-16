package com.alp.apitutorial;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    //modellerimizdeki entitylerimizi direkt apilar uzerinden acmak pek dogru olmaz. modellerimizi dısarıya acarken
    // onlara ait Dtolar olusturup bu sekilde sergilememiz daha dogru olur.
    private Long id ;

    String firstname;

    String lastname;

    List<String> adresses;
}
