package org.example.impl;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

class StringCharactersSetTest {
@Test
    public void intersectCharactersSet(){
    String []arr1 = {"a","b","c","d","e"};
    StringCharactersSet set1 = StringCharactersSet.fromArray("a","b","c","d","e");
//    StringCharactersSet set1 = new StringCharactersSet("a","b","c","d","e");not possible as constructor is private
    StringCharactersSet set2 = StringCharactersSet.fromSet(Set.of("k","l","a","b","c"));

    assertThat(set1.intersect(set2).getCharacters()).isEqualTo(Set.of("a","b","c"));
    assertThat(set2.intersect(set1).getCharacters()).isEqualTo(Set.of("a","b","c"));
}
}