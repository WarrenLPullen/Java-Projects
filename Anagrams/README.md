## Anagram Finder

### Description
This is a Java program that finds and stores collections of words and their anagrams.

### How it Works
1.  The program uses a `TreeMap` to store words as keys and their anagrams as `TreeSet` values.
2.  The `populate()` method adds sample words and their anagrams to the `TreeMap`.
3.  The `addAnagram()` method adds a new anagram for an existing word or creates a new entry in the map if the word doesn't exist.  It ensures that only actual anagrams are added.
4.  The `print()` method iterates through the map and prints each word along with its anagrams.
5.  The `areAnagrams()` method checks if two given words are anagrams by comparing their sorted character arrays.
6.  The `crossReference()` method updates the map to include cross-referenced anagrams. For example, if "list" has anagrams "silt" and "slit", it adds "list" to the anagrams of "silt" and "slit".

### Files
* `Anagram.java`: This file contains the Java code for the anagram finder.

### How to Use
1.  Compile the `Anagram.java` file using a Java compiler.
2.  Run the compiled class file (e.g., `java Anagram`).
3.  You can create an instance of the `Anagram` class and use its methods to populate the anagram map, add anagrams, print the contents, check if words are anagrams, and cross-reference anagrams.

### Code Details
* `Anagram.java`:
    * **Classes**:
        * `Anagram`:
            * `anagrams`: A `TreeMap<String, TreeSet<String>>` to store words and their anagrams.
            * `Anagram()`: Constructor to initialize the `anagrams` map.
            * `populate()`:  Adds sample words and their anagrams to the map.
            * `addAnagram(String aWord, String anAnagram)`: Adds an anagram for a word.
            * `print()`: Prints the contents of the anagram map.
            * `areAnagrams(String aWord, String anotherWord)`: Checks if two words are anagrams.
            * `crossReference()`:  Cross-references anagrams in the map.
