package com.company;

public class BankOnline {
    public void send(String number, Double money) throws BankOnlineException {
        String cardNumber;

        if (number == null || money == null)
            throw new NullArgumentExceprion("Пустой параметр");
        else
            cardNumber = number.replaceAll(" ", "");

        if(cardNumber.length() != 16 || !isNumeric(cardNumber))
            throw new InvalidCardNumberException("Номер карты должен состоять из 16 цифр");
        else if(cardNumber.equals("1111111111111111") || cardNumber.equals("2222222222222222") || cardNumber.equals("3333333333333333"))
            throw new BlockedCardException("Перевод на заблокированную карту невозможен");
        else if(money > 50000)
            throw new OutOfLimitTransferException("Превышение лимита в 50000");
        else if(money < 0)
            throw new NegativeTransferAmount("Отрицательная сумма перевода");
        else
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
}
