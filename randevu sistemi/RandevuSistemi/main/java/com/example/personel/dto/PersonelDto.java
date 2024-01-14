package com.example.personel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonelDto {
    private Long id;
    private String isim;
    private String soyisim;
    private String eposta;
}
