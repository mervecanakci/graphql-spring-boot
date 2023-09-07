package com.vendeton.graphql.exception;


import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class GraphqlException extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof UserNotFoundException) {
            return toGraphqlError(ex); // Hata bir UserNotFoundException ise GraphQL hata nesnesine dönüştürülüyor.
        } else if (ex instanceof Exception) {
            return toGraphqlError(ex); // Diğer tüm hatalar için aynı şekilde GraphQL hata nesnesine dönüştürülüyor.
        }
        return super.resolveToSingleError(ex, env); // Özel bir durum olmadığında, varsayılan işlem yapılıyor.
    }

    private GraphQLError toGraphqlError(Throwable throwable) {
        return GraphqlErrorBuilder.newError()
                .message(throwable.getMessage()) // Hata mesajı GraphQL hata nesnesine ekleniyor.
                .errorType(ErrorType.DataFetchingException) // Hata türü belirleniyor (DataFetchingException).
                .build(); // Oluşturulan GraphQL hata nesnesi döndürülüyor.
    }
}
