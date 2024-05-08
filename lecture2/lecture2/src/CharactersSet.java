public interface CharactersSet {

    // Implement methods for determining the intersection, union, difference of two sets
    //
    CharactersSet inersect(CharactersSet other);
    CharactersSet union(CharactersSet other);
    CharactersSet difference(CharactersSet other);
}
