package com.example.personel.service;

import com.example.personel.dto.MüsteriDto;
import java.util.List;

public interface MüsteriService {
    static MüsteriDto müsteriYarat(MüsteriDto müsteriDto) {
        return null;
    }

    MüsteriDto idIleGetir(Long müsteriId);

    List<MüsteriDto> tumMüsterileriGetir();

   MüsteriDto müsteriGuncelle(Long müsteriId, MüsteriDto guncellenenMüsteri);


    static void müsteriSil(Long müsteriId) {
    }
}