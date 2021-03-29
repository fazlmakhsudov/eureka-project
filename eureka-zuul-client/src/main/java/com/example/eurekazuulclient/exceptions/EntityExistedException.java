package com.example.eurekazuulclient.exceptions;

/**
 * Entity is already existed exception
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 29.03.21 21:11
 */
public class EntityExistedException extends RuntimeException {

    public EntityExistedException(String message) {
        super(message);
    }
}
