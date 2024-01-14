package com.example.personel.service.Impl;

import com.example.personel.dto.RandevularDto;
import com.example.personel.entity.RandevularEntity;
import com.example.personel.exception.KaynakBulunamadiException;
import com.example.personel.mapper.RandevularMapper;
import com.example.personel.repository.RandevuRepository;
import com.example.personel.service.RandevularService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RandevularServiceImpl implements RandevularService {
    private final RandevuRepository randevuRepository;

    @Override
    public RandevularDto randevuYarat(RandevularDto randevularDto) {
        RandevularEntity randevular = RandevularMapper.mapToRandevular(randevularDto);
        RandevularEntity kaydedilmisRandevular = randevuRepository.save(randevular);
        return RandevularMapper.mapToRandevularDto(kaydedilmisRandevular);
    }

    @Override
    public RandevularDto RANDEVULAR_DTO(RandevularDto randevularDto) {
        return null;
    }

    @Override
    public RandevularDto RandevuYarat(RandevularDto randevularDto) {
        return null;
    }

    @Override
    public RandevularDto dIleGetir(Long randevuId) {
        return null;
    }

    @Override
    public RandevularDto idIleGetir(Long randevuId) {
        RandevularEntity randevularEntity = randevuRepository.findById(randevuId)
                .orElseThrow(() -> new KaynakBulunamadiException("Bu id ile kayitli bir randevu bulunamadi. Id: " + randevuId));
        return RandevularMapper.mapToRandevularDto(randevularEntity);
    }

    @Override
    public List<RandevularDto> DTO_LIST() {
        return null;
    }


    @Override
    public List<RandevularDto> tumRandevulariGetir() {
        List<RandevularEntity> myrandevular = randevuRepository.findAll();
        return myrandevular.stream().map((randevular) -> RandevularMapper.mapToRandevularDto(randevular))
                .collect(Collectors.toList());
    }

    @Override
    public RandevularDto randevuGuncelle(Long randevuId, RandevularDto guncellenenRandevu) {
        RandevularEntity randevular = randevuRepository.findById(randevuId)
                .orElseThrow(() -> new KaynakBulunamadiException("Bu id ile kayitli bir randevu bulunamadi. Id: " + randevuId));

        randevular.setRandevu_id(guncellenenRandevu.getRandevu_id());
        randevular.setMusteri_id(guncellenenRandevu.getMusteri_id());


        RandevularEntity veritabanindaGuncellenmmisRandevu = randevuRepository.save(randevular);
        return RandevularMapper.mapToRandevularDto(veritabanindaGuncellenmmisRandevu);
    }

    @Override
    public void randevuSil(Long randevuId) {
        RandevularEntity randevular = randevuRepository.findById(randevuId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir randevu bulunamadi. Id: " + randevuId));

        randevuRepository.deleteById(randevuId);
    }



}