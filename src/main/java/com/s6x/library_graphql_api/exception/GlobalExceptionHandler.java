package com.s6x.library_graphql_api.exception;

import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@ControllerAdvice
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler
    public GraphQLError handleAuthorNotFoundException(AuthorNotFoundException ex, DataFetchingEnvironment env) {
        return GraphqlErrorBuilder.newError()
                .errorType(graphql.ErrorType.DataFetchingException)
                .message(ex.getMessage())
                .path(env.getExecutionStepInfo().getPath())
                .location(env.getField().getSourceLocation())
                .build();
    }

    @GraphQlExceptionHandler
    public GraphQLError handleBookNotFoundException(BookNotFoundException ex, DataFetchingEnvironment env) {
        return GraphqlErrorBuilder.newError()
                .errorType(graphql.ErrorType.DataFetchingException)
                .message(ex.getMessage())
                .path(env.getExecutionStepInfo().getPath())
                .location(env.getField().getSourceLocation())
                .build();
    }

    @GraphQlExceptionHandler
    public GraphQLError handleIllegalArgumentException(IllegalArgumentException ex, DataFetchingEnvironment env) {
        return GraphqlErrorBuilder.newError()
                .errorType(graphql.ErrorType.InvalidSyntax)
                .message("Invalid argument provided :::: " + ex.getMessage())
                .path(env.getExecutionStepInfo().getPath())
                .location(env.getField().getSourceLocation())
                .build();
    }

    @GraphQlExceptionHandler
    public GraphQLError handleGenericException (Exception ex, DataFetchingEnvironment env) {
        return GraphqlErrorBuilder.newError()
                .errorType(graphql.ErrorType.ExecutionAborted)
                .message("An unexpected error occurred: " + ex.getMessage())
                .path(env.getExecutionStepInfo().getPath())
                .location(env.getField().getSourceLocation())
                .build();
    }

}
