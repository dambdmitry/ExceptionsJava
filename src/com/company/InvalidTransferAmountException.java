package com.company;

public class InvalidTransferAmountException extends BankOnlineException {
    InvalidTransferAmountException(String msg) {
        super(msg);
    }
}
