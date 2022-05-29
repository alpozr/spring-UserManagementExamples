package com.alp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Document(indexName = "users",indexStoreType = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    private String id;
    @Field(name = "firstname",type = FieldType.Text)
    private String ad;
    @Field(name = "lastname",type = FieldType.Text)
    private String soyad;
    @Field(name = "date",type = FieldType.Date)
    private Date dogumtarihi;

}
