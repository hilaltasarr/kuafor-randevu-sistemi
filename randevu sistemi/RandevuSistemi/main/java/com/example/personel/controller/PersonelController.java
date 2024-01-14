package com.example.personel.controller;

import com.example.personel.dto.PersonelDto;
import com.example.personel.service.Impl.PersonelServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/personeller")
public class PersonelController {
    private PersonelServiceImpl personelService;

    //Personel ekleme islemi
    @PostMapping
    public ResponseEntity<PersonelDto> personelYarat(@RequestBody PersonelDto personelDto) {
        PersonelDto kayitEdilmisPersonel = personelService.personelYarat(personelDto);
        return new ResponseEntity<>(kayitEdilmisPersonel, HttpStatus.CREATED);
    }

    //Personel getirme islemi
    @GetMapping("{id}")
    public ResponseEntity<PersonelDto> idIleGetir(@PathVariable("id") Long personelId){
       PersonelDto personelDto= personelService.idIleGetir(personelId);
       return ResponseEntity.ok(personelDto);
    }

    //Tum personelleri getirme islemi
    @GetMapping
    public ResponseEntity<List<PersonelDto>> tumPersonelleriGetir(){
        List<PersonelDto> personelDtoList = personelService.tumPersonelleriGetir();
        return ResponseEntity.ok(personelDtoList);
    }

    //personel guncelleme
    @PutMapping("{id}")
    public ResponseEntity<PersonelDto> personelGuncelle(@PathVariable("id") Long personelId,
                                                        @RequestBody PersonelDto guncelPersonelDto){
        PersonelDto personelDto = personelService.personelGuncelle(personelId,guncelPersonelDto);
        return ResponseEntity.ok(personelDto);
    }

    //Personel Silme
    @DeleteMapping("{id}")
    public ResponseEntity<String> personelSil(@PathVariable("id") Long personelId){
        personelService.personelSil(personelId);
        return ResponseEntity.ok("Personel basariyla silindi.");
    }
}
