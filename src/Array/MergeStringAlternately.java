package Array;

public class MergeStringAlternately {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String word1 = "abc";
        String word2 = "pqr";
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
    }
}
