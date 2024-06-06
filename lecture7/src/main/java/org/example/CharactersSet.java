package org.example;

import java.util.Set;

public interface CharactersSet<T> {
  CharactersSet<T>  intersect(CharactersSet<T> other);
   CharactersSet<T>union(CharactersSet<T> other);
    CharactersSet<T> difference(CharactersSet<T> other);
    Set<T>getCharacters();

}
