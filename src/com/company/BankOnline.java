package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankOnline {
    public void send(String number, Double money) throws BankOnlineException {
        if (number == null || money == null) {
            throw new NullArgumentExceprion("Пустой параметр");
        }

        String cardNumber = number.replaceAll(" ", "");
        if(!validateCardNumber(cardNumber)) {
            throw new InvalidCardNumberException("Номер карты должен состоять из 16 цифр");
        }
        else if(isBlockedCard(cardNumber)) {
            throw new BlockedCardException("Перевод на заблокированную карту невозможен");
        }
        else if(!validateTransferAmount(money)) {
            throw new InvalidTransferAmount("Недопустимая сумма перевода");
        }

        System.out.println("Перевод выполнен");
    }

    private boolean isNumeric(String str){
        try{
            long l = Long.parseLong(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private boolean isBlockedCard(String cardNumber){
        try{
            Scanner in = new Scanner(new File("BlockedCards.txt"));
            while (in.hasNextLine())
                if(cardNumber.equals(in.nextLine())){
                    return true;
                }
        }catch (FileNotFoundException e){
            System.out.println("Потерян файл 'BlockedCards.txt'");
        }
        return false;
    }

    //Считается что в параматре cardNumber все пробелы удалены.
    private boolean validateCardNumber(String cardNumber){
        return cardNumber.length() == 16 && isNumeric(cardNumber);
    }

    private boolean validateTransferAmount(double money){
        return 0 <= money && money <= 50000;
    }
}
