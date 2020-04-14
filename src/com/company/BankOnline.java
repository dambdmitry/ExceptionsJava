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

        // Проверка корректности введеных данных.
        validateCardNumber(cardNumber);
        validateTransferAmount(money);

        System.out.println("Перевод выполнен");
    }

    private boolean isNumeric(String str){
        try{
            Long.parseLong(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private void notBlockedCard(String cardNumber) throws BankOnlineException{
        try(Scanner in = new Scanner(new File("BlockedCards.txt"));){
            while (in.hasNextLine())
                if(cardNumber.equals(in.nextLine())){
                    throw new BlockedCardException("Перевод на заблокированную карту невозможен");
                }
        }catch (FileNotFoundException e){
            System.out.println("Потерян файл 'BlockedCards.txt'");
        }
    }
    
    //Считается что в параматре cardNumber все пробелы удалены.
    private void validateCardNumber(String cardNumber) throws BankOnlineException {
        if(cardNumber.length() != 16 || !isNumeric(cardNumber)){
            throw new InvalidCardNumberException("Номер карты должен состоять из 16 цифр");
        }
        notBlockedCard(cardNumber);
    }

    private void validateTransferAmount(double money) throws BankOnlineException{
        if(money < 0 || 50000 < money){
            throw new InvalidTransferAmountException("Недопустимая сумма перевода");
        }
    }
}
