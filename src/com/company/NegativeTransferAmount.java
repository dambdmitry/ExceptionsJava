package com.company;

public class NegativeTransferAmount extends BankOnlineException {
    NegativeTransferAmount(String msg) {
        super(msg);
    }
}
