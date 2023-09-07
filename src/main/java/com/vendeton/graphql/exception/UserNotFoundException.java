package com.vendeton.graphql.exception;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException { // RuntimeException:
    public UserNotFoundException(String message) {
        super(message); // Verilen mesajla birlikte UserNotFoundException oluşturuluyor.
    }
}
/* RuntimeException:
* RuntimeException, Java'da birçok hata durumunu temsil eden bir üst sınıftır.
* Bu tür hatalar, programın çalışma zamanında ortaya çıkan ve programcının önceden yakalamak için
* belirli bir istisna (exception) türüne ihtiyaç duymadığı hataları temsil eder.
* Örneğin, dizin sınırları aşma hatası veya null bir nesne üzerinde işlem yapma hatası gibi
* programın düzgün çalışma zamanında ortaya çıkan hatalar bu kategoriye girer.
* UserNotFoundException sınıfı, belirli bir kullanıcıyı bulamadığında ortaya çıkabilecek bir
* çalışma zamanı istisnasıdır ve bu nedenle RuntimeException sınıfından türetilmiştir.
*/