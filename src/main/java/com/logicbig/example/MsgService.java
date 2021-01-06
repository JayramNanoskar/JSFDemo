package com.logicbig.example;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public interface MsgService {
    String getMsg();

    @Service
    public static class DefaultMsgService implements MsgService {
        @Override
        public String getMsg() {
            return String.format("We are adding UI Controls !!!!");
        }
    }
}