package it.aleph.omega.exception;

import lombok.Builder;

import java.util.List;

@Builder
public class NotFoundException extends RuntimeException{

    private List<Long> idListNotFound;
    private String message;

}
