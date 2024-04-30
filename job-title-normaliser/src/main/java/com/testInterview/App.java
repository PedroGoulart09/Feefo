package com.testInterview;

import com.testInterview.Normaliser.Normaliser;

public class App
{
    public static void main( String[] args )
    {
        Normaliser normaliser = new Normaliser();
        System.out.println(normaliser.normalise("Java engineer"));
    }
}
