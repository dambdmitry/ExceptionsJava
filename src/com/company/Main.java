package com.company;

public class Main {

    public static void main(String[] args) {
	    BankOnline bank = new BankOnline();
	    try {
            bank.send("3333 3333 3333 3333", null );
        }catch (BankOnlineException e){
            System.out.println(e.getMessage());
        }

    }
}
