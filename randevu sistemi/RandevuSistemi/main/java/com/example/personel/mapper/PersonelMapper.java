package com.example.personel.mapper;

import com.example.personel.dto.PersonelDto;
import com.example.personel.entity.PersonelEntity;

public class PersonelMapper {
    public static PersonelDto mapToPersonelDto(PersonelEntity personel){
        return new PersonelDto(
                personel.getId(),
                personel.getIsim(),
                personel.getSoyisim(),
                personel.getEposta()
        );
    }

    public static PersonelEntity mapToPersonel(PersonelDto personelDto){
        return new PersonelEntity(
                personelDto.getId(),
                personelDto.getIsim(),
                personelDto.getSoyisim(),
                personelDto.getEposta()
        );
    }
}
