package Array;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReverseVowels {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] str = s.toCharArray();

        Stack<Character> vowelsArray = new Stack<>();
        for (Character c : str) {
            if (vowels.contains(c)) {
                vowelsArray.add(c);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                str[i] = vowelsArray.pop();
            }
        }
        return new String(str);
    }

}
