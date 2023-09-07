package com.vendeton.graphql.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.idl.RuntimeWiring.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
//Date time ekledik; scaler olan hata veriyor bulması için de bu config i ekledik
@Configuration
public class GraphQLConfig { // GraphQLConfig sınıfı graphql-java ExtendedScalars.DateTime kullanımı için gerekli
    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer() { // runtimeWiringConfigurer: graphql-java ExtendedScalars.DateTime kullanımı için gerekli
        return new RuntimeWiringConfigurer() {
            @Override
            public void configure(Builder builder) { // Builder: graphql-java ExtendedScalars.DateTime kullanımı için gerekli ayrıca builder içinde gelen scalar tipleri için kullanılır. scalar; https://graphql.org/learn/schema/#scalar-types
                builder.scalar(ExtendedScalars.DateTime); // ExtendedScalars.DateTime yazdık sebebi ise graphql-java ExtendedScalars.DateTime kullanımı için gerekli ayrıca builder içinde gelen scalar tipleri için kullanılır. scalar; https://graphql.org/learn/schema/#scalar-types ve https://www.graphql-java.com/documentation/v16/scalars/
            // extended scalars aynı zamanda farklı tiplerde de kullanılabilir. Örneğin; builder.scalar(ExtendedScalars.GraphQLLong); gibi bunun da amacı; graphql-java ExtendedScala
            }
        };
    }
}

//        return runtimeWiringBuilder -> runtimeWiringBuilder
//                .type("Query", typeWiring -> typeWiring
//                        .dataFetcher("hello", env -> "Hello World!"));
//    }
//}
