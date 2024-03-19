package com.dirtiestcontext.dice_api.exceptions

import groovy.transform.InheritConstructors
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@InheritConstructors
@ResponseStatus(HttpStatus.BAD_REQUEST)
class BooleanException extends RuntimeException {
}
