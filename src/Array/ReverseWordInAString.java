package Array;

public class ReverseWordInAString {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if  (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
