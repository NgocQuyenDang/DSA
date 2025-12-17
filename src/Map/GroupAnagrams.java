package Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<String> str = new ArrayList<>(Arrays.asList(strs));
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < str.size(); i++) {
            List<String> temp = new ArrayList<>();
            temp.add(str.get(i));
            int j = i + 1;
            while (j <  str.size()) {
                if (isAnagram(str.get(i), str.get(j))) {
                    temp.add(str.get(j));
                    str.remove(String.valueOf(str.get(j)));
                }
                j++;
            }
            ans.add(temp);
            str.removeAll(temp);
            i = -1;
        }
        return ans;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);

            String originalString = new String(c);
            if (!map.containsKey(originalString)) {
                map.put(originalString, new ArrayList<>());
            }
            map.get(originalString).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> ans = new GroupAnagrams().groupAnagrams(strs);
        System.out.println(ans.toString());
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
