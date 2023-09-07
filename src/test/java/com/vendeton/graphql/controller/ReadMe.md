# 📌 GraphQL
#### GraphQL, Facebook tarafından geliştirilen bir sorgulama dilidir. Geleneksel RESTful API'lerin yerini alabilecek bir alternatif olarak ortaya çıkmıştır. GraphQL, istemcilerin ihtiyaç duydukları verileri belirlemelerine olanak tanır ve sunucudan sadece bu verileri alır. Bu sayede gereksiz veri transferi önlenir ve ağ trafiği azaltılır.
#### GraphQL'in temel felsefesi, istemcilerin veri taleplerini esnek bir şekilde tanımlayabilmesidir. İstemci, sadece ihtiyaç duyduğu verileri belirtir ve sunucu, sadece bu verileri döndürür. Bu, istemcilerin birden fazla API çağrısı yapmak zorunda kalmadan veri almasını sağlar.
#### Spring Boot, GraphQL sorgularını işlemek için gerekli altyapıyı sağlar ve GraphQL sorgularını Spring Boot uygulamasına entegre etmek oldukça kolaydır. 
### 📝 GraphQL'in Temel Özellikleri:
- #### İstemciler, sadece istedikleri verileri almak için sorgularını özelleştirebilirler. Bu, gereksiz veri transferini ve aşırı yüklenmiş istekleri engeller.
- #### GraphQL, tek bir API noktası üzerinden tüm verilere erişimi sağlar, bu da RESTful API'lerdeki çok sayıda noktayla karşılaştırıldığında daha kolay bakım yapılmasını sağlar.
- #### GraphQL, veri tiplerini tanımlama avantajı sunar. Bu, verilerin ne tür olduğunu belirlemeyi kolaylaştırır ve dökümantasyonu geliştirir.
- #### GraphQL, ilişkisel verilere kolay erişim sağlar ve gerektiğinde ilişkili verileri almayı mümkün kılar.
http://localhost:8080/graphiql?path=/graphql