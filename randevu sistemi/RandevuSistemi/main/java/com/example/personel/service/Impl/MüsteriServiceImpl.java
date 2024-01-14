package com.example.personel.service.Impl;

import com.example.personel.dto.MüsteriDto;
import com.example.personel.entity.MüsteriEntity;
import com.example.personel.exception.KaynakBulunamadiException;
import com.example.personel.mapper.MüsteriMapper;
import com.example.personel.repository.MüsteriRepository;
import com.example.personel.service.MüsteriService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MüsteriServiceImpl implements MüsteriService {
    private MüsteriRepository müsteriRepository;


    @Override
    public MüsteriDto müsteriYarat(MüsteriDto müsteriDto) {
        MüsteriEntity MüsteriEntity = MüsteriMapper.mapToMüsteri(müsteriDto);
        MüsteriEntity kaydedilmisMüsteriler = müsteriRepository.save(MüsteriEntity);
        return MüsteriMapper.mapToMüsteriDto(kaydedilmisMüsteriler);
    }

    @Override
    public MüsteriDto idIleGetir(Long müsteriId) {
        MüsteriEntity müsteriEntity = müsteriRepository.findById(müsteriId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir müsteri bulunamadi. Id: " + müsteriId));
        return MüsteriMapper.mapToMüsteriDto(müsteriEntity);
    }

    @Override
    public List<MüsteriDto> tumMüsterileriGetir() {
        List<MüsteriEntity> mymüsteriler = müsteriRepository.findAll();
        return mymüsteriler.stream().map((müsteri ) -> MüsteriMapper.mapToMüsteriDto(müsteri))
                .collect(Collectors.toList());
    }


    @Override
    public MüsteriDto müsteriGuncelle(Long musteriId,MüsteriDto guncellenenMüsteri) {
        MüsteriEntity müsteriEntity = müsteriRepository.findById(musteriId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir müsteri bulunamadi. Id: " + musteriId));

        müsteriEntity.setIsim(guncellenenMüsteri.getIsim());
        müsteriEntity.setSoyisim(guncellenenMüsteri.getSoyisim());
        müsteriEntity.setTelefonNo(guncellenenMüsteri.getTelefonNo());

        MüsteriEntity veritabanindaGuncellenmmisMüsteri = müsteriRepository.save(müsteriEntity);
        return MüsteriMapper.mapToMüsteriDto(veritabanindaGuncellenmmisMüsteri);
    }

    @Override
    public void müsteriSil(Long müsteriId) {
        MüsteriEntity müsteriEntity = müsteriRepository.findById(müsteriId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir musteri bulunamadi. Id: " + müsteriId));

        müsteriRepository.deleteById(müsteriId);
    }
}