package com.company;

public class Main {

    public static void main(String[] args) {
	    Thready FirstThread = new Thready(1);
	    Thready SecondThread = new Thready(2);
	    Thready ThirdThread = new Thready(3);
	    FirstThread.start();
	    SecondThread.start();
	    ThirdThread.start();
    }
}
