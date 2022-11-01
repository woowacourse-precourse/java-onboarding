package onboarding;


/**
 * Problem 2
 * @author Davin An
 * @version 1.0
 */
public class Problem2 {

    /**
     * Looks for pairs within a string and eliminates them
     * @param cryptogram Original string to be decrypted
     * @return String after all pairs are eliminated
     */
    public static String solution(String cryptogram) {
        char[] str = cryptogram.toCharArray();
        char[] pattern = new char[cryptogram.length() + 1];
        int index = 1;
        for (char c : str) {
            if (pattern[index - 1] == c) {
                pattern[index - 1] = '\u0000';
                index--;
            } else {
                pattern[index] = c;
                index++;
            }
        }
        return String.valueOf(pattern).trim();
    }

    /*
    Example
    | index | str | pattern |
    |-------|-----|---------|
    | 1     | b   | _b      |
    | 2     | r   | _br     |
    | 3     | o   | _bro    |
    | 4     | w   | _brow   |
    | 5     | o   | _browo  |
    | 6     | a   | _browoa |
    | 5     | a   | _browo  |
    | 4     | o   | _brow   |
    | 5     | n   | _brown  |
     */

    public static void main(String[] args) {}
}
