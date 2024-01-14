package com.example.personel.mapper;



import com.example.personel.dto.RandevularDto;
import com.example.personel.entity.RandevularEntity;



    public class RandevularMapper {
        public static RandevularDto mapToRandevularDto(RandevularEntity randevular){
            return new RandevularDto(
                    randevular.getRandevu_id(),
                    randevular.getMusteri_id()

            );
        }

        public static RandevularEntity mapToRandevular(RandevularDto randevularDto){
            return new RandevularEntity(
                    randevularDto.getMusteri_id(),
                    randevularDto.getRandevu_id()

            );
        }
    }

