package org.example.impl;

import org.example.CharactersSet;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCharactersHelperTest {
    @Test
    public void subtractCharactersSet(){
        CharactersSet<String>result = StringCharactersHelper.subtractCharactersSet(
                new StringCharactersSet[]{StringCharactersSet.fromArray("a","b","c")},
                new StringCharactersSet[]{StringCharactersSet.fromArray("c","d","e")}
        );

        assertThat(result.getCharacters()).containsExactlyInAnyOrder("a","b");
    }

}