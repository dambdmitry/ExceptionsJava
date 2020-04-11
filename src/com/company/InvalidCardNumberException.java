package com.company;

public class InvalidCardNumberException extends BankOnlineException {
    InvalidCardNumberException(String msg) {
        super(msg);
    }
}
