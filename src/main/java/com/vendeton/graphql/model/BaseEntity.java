package com.vendeton.graphql.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@SuperBuilder
// SuperBuilder bu sınıfın alt sınıflarını oluşturur ve bu sınıfın alt sınıflarını oluştururken bu sınıfın builder'ını kullanır
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
// bu anotasyon; sınıfı veritabanı tablosuna eşlemek için kullanılır ve bu sınıf için herhangi bir tablo oluşturmaz.
public abstract class BaseEntity { // abstract: bu sınıfın nesnesi oluşturulamaz
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    // @CreationTimestamp: veritabanına kayıt oluşturulduğunda otomatik olarak tarih ve saat bilgisi ekler
    // private LocalDateTime created;
     private OffsetDateTime created;
    /* şimdi sorgu yaparken bunlar gelmiyor(oluşturma zamanı ve güncelleme zamanı sadece) ama Offset olunca oluyor bilgisel burada kalsın */
    @UpdateTimestamp
    // @UpdateTimestamp: veritabanına kayıt güncellendiğinde otomatik olarak tarih ve saat bilgisi ekler
    // private LocalDateTime update;
     private OffsetDateTime updated;
}
