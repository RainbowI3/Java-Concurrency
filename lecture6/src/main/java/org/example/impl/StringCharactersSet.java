package org.example.impl;

import org.example.CharactersSet;

import java.util.*;

public  class StringCharactersSet implements CharactersSet {
    private final Set<String> content;


    public static StringCharactersSet fromSet(Set<String>initial){
        return new StringCharactersSet(new HashSet<>(initial));
    }
    public static StringCharactersSet fromArray(String...initial){
        return new StringCharactersSet(initial);
    }


    private StringCharactersSet(String ... initialSet) {

        content = new HashSet<>(List.of(initialSet));
//        Collections.addAll(content,initialSet);
    }


    private StringCharactersSet(Set<String> content){
        this.content = content;
    }

    @Override
    public StringCharactersSet intersect(CharactersSet other) {
        if(other instanceof StringCharactersSet){
            StringCharactersSet otherStringCharactersSet = (StringCharactersSet) other;

            Set<String> newContent = getCharacters();
            newContent.retainAll(otherStringCharactersSet.getCharacters());


            return  new StringCharactersSet(newContent);
        }

        return null;


    }

    @Override
    public StringCharactersSet union(CharactersSet other) {
        return null;
    }

    @Override
    public StringCharactersSet difference(CharactersSet other) {

        return null;
    }

   public Set<String> getCharacters(){return new HashSet<>(content);
    }
}
