package com.company;

public class BlockedCardException extends BankOnlineException {
    BlockedCardException(String msg) {
        super(msg);
    }
}
