package org.dmm.handler;

import org.dmm.exception.NoDataException;
import org.dmm.message.Message;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pohoulong on 2018/1/15.
 */
@ControllerAdvice
public class NoDataHandler {

    @ExceptionHandler(value = NoDataException.class)
    @ResponseBody
    public Message handle(NoDataException e) {
        return Message.error(e.getCode(), e.getMessage());
    }
}
