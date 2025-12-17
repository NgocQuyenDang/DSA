package String;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int count;
        int writeIndex = 0;
        int currentIndex = 0;
        while (currentIndex < chars.length) {
            count = 1;
            char current = chars[currentIndex];
            int tempIndex = currentIndex + 1;
            while (tempIndex < chars.length &&  chars[tempIndex] == current) {
                count++;
                tempIndex++;
            }
            currentIndex = tempIndex;
            chars[writeIndex++] = current;
            if (count > 1) {
                String str = String.valueOf(count);
                for (char c : str.toCharArray()) {
                    chars[writeIndex++] = c;
                }
            }
        }
        return writeIndex;
    }
}
