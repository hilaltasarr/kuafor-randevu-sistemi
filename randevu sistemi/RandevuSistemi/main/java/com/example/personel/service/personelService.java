package com.example.personel.service;
import com.example.personel.dto.PersonelDto;
import java.util.List;

public interface personelService {
    PersonelDto personelYarat(PersonelDto personelDto);
    PersonelDto idIleGetir(Long personelId);

    List<PersonelDto> tumPersonelleriGetir();

    PersonelDto personelGuncelle(Long personelId, PersonelDto guncellenenPersonel);

    void personelSil(Long personelId);
}