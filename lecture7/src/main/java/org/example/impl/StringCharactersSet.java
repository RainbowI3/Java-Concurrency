package org.example.impl;

import org.example.CharactersSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public  class StringCharactersSet implements CharactersSet<String> {
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
    public StringCharactersSet intersect(CharactersSet<String> other) {

            Set<String> newContent = getCharacters();
            newContent.retainAll(other.getCharacters());


            return  new StringCharactersSet(newContent);
        }


    @Override
    public StringCharactersSet union(CharactersSet<String> other) {
        return null;
    }

    @Override
    public StringCharactersSet difference(CharactersSet<String> other) {

        return null;
    }

    @Override
   public Set<String> getCharacters(){
       return new HashSet<>(content);
       // return content;
    }
}
