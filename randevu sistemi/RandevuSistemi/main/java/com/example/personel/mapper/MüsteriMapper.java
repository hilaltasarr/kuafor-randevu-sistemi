package com.example.personel.mapper;

import com.example.personel.dto.MüsteriDto;
import com.example.personel.entity.MüsteriEntity;

public class MüsteriMapper {
    public static MüsteriDto mapToMüsteriDto(MüsteriEntity müsteri){
        return new MüsteriDto(
                müsteri.getId(),
                müsteri .getIsim(),
                müsteri.getSoyisim(),
                müsteri.getEposta(),
                müsteri.getTelefonNo(),
                müsteri.getSifre(),
                müsteri.getKullaniciAdi()

        );
    }
    public static MüsteriEntity mapToMüsteri(MüsteriDto müsteriDto){
        return new MüsteriEntity(
                müsteriDto.getId(),
                müsteriDto.getIsim(),
                müsteriDto.getSoyisim(),
                müsteriDto.getEposta(),
                müsteriDto.getTelefonNo(),
                müsteriDto.getSifre(),
                müsteriDto.getKullaniciAdi()
        );
    }
}
