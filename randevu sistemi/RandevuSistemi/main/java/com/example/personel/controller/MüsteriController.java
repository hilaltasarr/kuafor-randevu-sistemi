package com.example.personel.controller;

import com.example.personel.dto.MüsteriDto;
import com.example.personel.service.MüsteriService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/müsteriler")
public class MüsteriController {
    private MüsteriService müsteriService;

    //müsteri ekleme islemi
    @PostMapping
    public ResponseEntity<MüsteriDto> müsteriYarat(@RequestBody MüsteriDto müsteriDto) {
        MüsteriDto kayitEdilmisMüsteri = MüsteriService.müsteriYarat(müsteriDto);
        return new ResponseEntity<>(kayitEdilmisMüsteri, HttpStatus.CREATED);
    }

    //Personel getirme islemi
    @GetMapping("{id}")
    public ResponseEntity<MüsteriDto> idIleGetir(@PathVariable("id") Long müsteriId){
        MüsteriDto personelDto= müsteriService.idIleGetir(müsteriId);
        return ResponseEntity.ok(personelDto);
    }

    //Tum müsteriileri getirme islemi
    @GetMapping
    public ResponseEntity<List<MüsteriDto>> tumMüsterileriGetir(){
        List<MüsteriDto> müsteriDtoList = müsteriService.tumMüsterileriGetir();
        return ResponseEntity.ok(müsteriDtoList);
    }

    //müsteri guncelleme
    @PutMapping("{id}")
    public ResponseEntity<MüsteriDto> müsteriGuncelle(@PathVariable("id") Long müsteriId,
                                                      @RequestBody MüsteriDto guncelMüsteriDto){
        MüsteriDto müsteriDto =MüsteriService.müsteriGuncelle(müsteriId,guncelMüsteriDto);
        return ResponseEntity.ok(müsteriDto);
    }

    //müsteri Silme
    @DeleteMapping("{id}")
    public ResponseEntity<String> müsteriSil(@PathVariable("id") Long müsteriId){
        MüsteriService.müsteriSil(müsteriId);
        return ResponseEntity.ok("Müsteri basariyla silindi.");
    }
}

