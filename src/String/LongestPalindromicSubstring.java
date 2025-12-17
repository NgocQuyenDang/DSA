package String;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            String odd = expand(s, i, i);
            if (odd.length() > maxLen) {
                maxLen = odd.length();
                res = odd;
            }

            String even = expand(s, i, i + 1);
            if (even.length() > maxLen) {
                maxLen = even.length();
                res = even;
            }
        }
        return res;
    }

    public String expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
