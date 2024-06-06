package org.example;

import java.util.Set;

public interface CharactersSet {
  CharactersSet  intersect(CharactersSet other);
   CharactersSet union(CharactersSet other);
    CharactersSet difference(CharactersSet other);
    Set<String>getCharacters();

}
