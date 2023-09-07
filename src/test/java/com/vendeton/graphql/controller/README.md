
## 📝 GraphQL Test Sorguları:
##### @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT):
```
Bu annotation, Spring Boot uygulamanızı test etmek için kullanılır.
webEnvironment parametresi, uygulamanın hangi ortamda çalıştırılacağını belirler. SpringBootTest.WebEnvironment.RANDOM_PORT, rastgele bir kullanılabilir bağlantı noktası üzerinde başlatılacak bir web sunucusu kullanılacağını belirtir. Bu, gerçek bir web sunucusu olmadan uygulamayı test etmeye olanak tanır.
  ```
##### @AutoConfigureMockMvc:
```
Bu annotation, Spring MVC sınıfını kullanarak MVC (Model-View-Controller) bileşenlerini test etmek için kullanılır.
MockMvc sınıfı, HTTP istekleri göndermek ve sonuçlarını incelemek için kullanılır. Bu, MVC denetleyicilerinive API'leri test etmek için kullanışlıdır.
```
##### @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD):
```
Bu annotation, testler arasında Spring uygulama bağlamını yeniden oluşturmayı sağlar.
classMode parametresi, ne zaman bağlamın temizlenmesi gerektiğini belirler. AFTER_EACH_TEST_METHOD, her test metodu çalıştırıldığında bağlamın temizlenmesini sağlar. Bu, her testin bağımsız olduğundan ve diğer testlerin sonuçlarından etkilenmediğinden emin olmaya yardımcı olur.
```
##### @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY):
```
Bu annotation, test veritabanını nasıl yapılandırılacağını belirler.
replace parametresi, mevcut veritabanı yapılandırmasını değiştirmek için kullanılır. AutoConfigureTestDatabase.Replace.ANY, mevcut veritabanı yapılandırmasını herhangi bir veritabanı (örneğin H2) ile değiştirir. Bu, testlerin gerçek veritabanına etki etmesini önler ve daha kontrol edilebilir bir test ortamı sağlar.
```
##### @AutoConfigureGraphQlTester:
```
Bu annotation, GraphQL testlerini kolaylaştırmak için kullanılır.
GraphQL sorgularını ve cevaplarını test etmek için kullanılan özel bir test bileşeni ekler.
