package com.example.personel.dto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class MüsteriDto  {
    private Long id;
    private String isim;
    private String soyisim;
    private VarcharJdbcType  eposta;
    private Integer telefonNo;
    private VarcharJdbcType sifre;
    private VarcharJdbcType kullaniciAdi;



}

