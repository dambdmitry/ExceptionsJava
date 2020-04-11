package com.company;

public class OutOfLimitTransferException extends BankOnlineException {
    OutOfLimitTransferException(String msg) {
        super(msg);
    }
}
