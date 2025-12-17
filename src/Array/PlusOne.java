package Array;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n;
        while (digits[i - 1] == 9) {
            digits[i - 1] = 0;
            i--;
            if (i == 0) {
                int[] newDigits = createNew(digits);
                newDigits[i] = digits[0] + 1;
                return newDigits;
            }
        }
        digits[i - 1]++;
        return digits;
    }

    public static int[] createNew(int[] digits) {
        int[] newArray = new int[digits.length + 1];
        for (int i = 0; i < digits.length; i++) {
            newArray[i + 1] = digits[i];
        }
        return newArray;
    }
}
