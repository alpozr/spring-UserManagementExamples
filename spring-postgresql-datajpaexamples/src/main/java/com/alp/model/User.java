package com.alp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity // Veritabanında tutulacak bir adres ldugundan ve JPA ile calistigimizdan Entity anotasyonu geliyor.
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of ={"id"} ) //idler esitse iki nesne birbirine esittir anotasyonumuz yine lomboktan geliyor.
@ToString
public class User {
    @Id
    @SequenceGenerator(name="seq_useradress",allocationSize = 1)
    @GeneratedValue(generator = "seq_useradress",strategy = GenerationType.SEQUENCE)
    //Generated value yukarıdaki sequanceden idyi alip asagıdaki long alanındaki idye dolduracaktir.
    //Bunu generate ederken belirtmek durumundayiz,ancak MySQL gibi yapilarda bu oto yapilmaktadır.
    private Long id ;

    @Column(length = 100,   name = "firstname")//Colonumuzun bu olacagini söyledik
    String firstname;
    @Column(length = 100,   name = "lastname")//Colonumuzun bu olacagini söyledik
    String lastname;

    //Relational bir veritabanı olacagindan bize join islemi gerekiyor.
    @OneToMany//Bir kisi birden cok adresi olabileceginden OneToMany anotasyonu kullandik.
    @JoinColumn(name = "user_adress_id")
    private List<Adress> adresses;
}
