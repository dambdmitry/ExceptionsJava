package com.company;

public class InvalidTransferAmount extends BankOnlineException {
    InvalidTransferAmount(String msg) {
        super(msg);
    }
}
