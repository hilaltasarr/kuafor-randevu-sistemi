package com.example.personel.service;
import com.example.personel.dto.RandevularDto;
import java.util.List;


public interface RandevularService {
    static RandevularDto randevuYarat(RandevularDto randevularDto);

    RandevularDto RANDEVULAR_DTO(RandevularDto randevularDto);

    RandevularDto RandevuYarat(RandevularDto randevularDto);

     RandevularDto dIleGetir(Long randevuId);

    static RandevularDto idIleGetir(Long randevuId);

     List<RandevularDto> DTO_LIST();

    static List<RandevularDto> tumRandevulariGetir();

    RandevularDto randevuGuncelle(Long randevuId, RandevularDto guncellenenRandevu);

    void randevuSil(Long randevuId);


}