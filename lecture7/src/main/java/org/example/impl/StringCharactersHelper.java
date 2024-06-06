package org.example.impl;

import org.example.CharactersSet;

import java.util.Set;

public class StringCharactersHelper {

    public static <T> CharactersSet<T> subtractCharactersSet(CharactersSet<T>[] set1, CharactersSet<T>[] set2){
        return  set1[0].difference(set2[0]);
    }
}
