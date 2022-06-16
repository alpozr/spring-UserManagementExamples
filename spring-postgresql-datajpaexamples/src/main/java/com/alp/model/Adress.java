package com.alp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity // Veritabanında tutulacak bir adres ldugundan ve JPA ile calistigimizdan Entity anotasyonu geliyor.
@Table(name="user_adress")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of ={"id"} ) //idler esitse iki nesne birbirine esittir anotasyonumuz yine lomboktan geliyor.
@ToString
public class Adress implements Serializable {

    @Id
    @SequenceGenerator(name="seq_useradress",allocationSize = 1)
    @GeneratedValue(generator = "seq_useradress",strategy = GenerationType.SEQUENCE)
    //Generated value yukarıdaki sequanceden idyi alip asagıdaki long alanındaki idye dolduracaktir.
    //Bunu generate ederken belirtmek durumundayiz,ancak MySQL gibi yapilarda bu oto yapilmaktadır.
    private Long id ;

    @Column(length = 500,name = "AdressRepository")//Colonumuzun bu olacagini söyledik
    String adress;

    @Enumerated //asagidaki degisken Enum ile olusturuldugundan bu anotasyon zorunlu
    AdressType adressType;
    @Column(name = "active")//boolean bir degiskenin uzunlugu ya 0 ya 1dir.belli oldugundan length vermemize gerek yoktur.
    boolean active;

    @ManyToOne//Bir adres birden cok kisiye ait olamaz, Ama bir kisinin birden cok adresi olabilir.
    @JoinColumn(name = "user_adress_id")
    private User user ;

    public enum AdressType{
        HOME_ADRESS,
        WORK_ADRESS,
        OTHER
    }

}
