package com.example.personel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="müsteriler")

public class MüsteriEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isim;
    private String soyisim;
    @Column(name = "eposta_id", nullable = false, unique = true)
    private VarcharJdbcType  eposta;
    private int telefonNo;
    private VarcharJdbcType  kullaniciAdi;
    private VarcharJdbcType sifre;

}

