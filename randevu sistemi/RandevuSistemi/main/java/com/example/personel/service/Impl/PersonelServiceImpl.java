package com.example.personel.service.Impl;
import com.example.personel.dto.PersonelDto;
import com.example.personel.entity.MüsteriEntity;
import com.example.personel.entity.PersonelEntity;
import com.example.personel.exception.KaynakBulunamadiException;
import com.example.personel.mapper.MüsteriMapper;
import com.example.personel.mapper.PersonelMapper;
import com.example.personel.repository.PersonelRepository;
import com.example.personel.service.personelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class PersonelServiceImpl implements personelService {
    private PersonelRepository personelRepository;
    @Override
    public PersonelDto personelYarat(PersonelDto personelDto) {
        PersonelEntity personel = PersonelMapper.mapToPersonel(personelDto);
        PersonelEntity kaydedilmisPersonel = personelRepository.save(personel);
        return PersonelMapper.mapToPersonelDto(kaydedilmisPersonel);
    }

    @Override
    public PersonelDto idIleGetir(Long personelId) {
        PersonelEntity personel = personelRepository.findById(personelId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir personel bulunamadi. Id: " + personelId));
        return PersonelMapper.mapToPersonelDto(personel);
    }

    @Override
    public List<PersonelDto> tumPersonelleriGetir() {
        List<PersonelEntity> personeller = personelRepository.findAll();
        return personeller.stream().map((personel) -> PersonelMapper.mapToPersonelDto(personel))
                .collect(Collectors.toList());
    }

    @Override
    public PersonelDto personelGuncelle(Long personelId, PersonelDto guncellenenPersonel) {
        PersonelEntity personelEntity = personelRepository.findById(personelId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir personel bulunamadi. Id: " + personelId));
        personelEntity.setId(guncellenenPersonel.getId());
        personelEntity.setIsim(guncellenenPersonel.getIsim());
        personelEntity.setSoyisim(guncellenenPersonel.getSoyisim());
        personelEntity.setEposta(guncellenenPersonel.getEposta());

        PersonelEntity veritabanindaGuncellenmisPersonel = personelRepository.save (new PersonelEntity());
        return PersonelMapper.mapToPersonelDto(veritabanindaGuncellenmisPersonel);
    }


    @Override
    public void personelSil(Long personelId) {
        PersonelEntity personel = personelRepository.findById(personelId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir personel bulunamadi. Id: " + personelId));

        personelRepository.deleteById(personelId);
    }
}