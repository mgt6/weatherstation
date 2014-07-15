package com.github.mgt6.weatherstation.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Basic exception that can be mapped to a resource not found exception to be return if a requested resource is not available.
 */
@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
}
