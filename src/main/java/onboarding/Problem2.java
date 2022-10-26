package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        for (int index = 0; index < cryptogram.length() - 1; index++) {
            if (isEqualsTwoChar(cryptogram.charAt(index), cryptogram.charAt(index + 1))) {
                cryptogram = removeTwoEqualsChar(cryptogram, index);
                index = revertIndex(index);
            }
        }
        
        return cryptogram;
    }
    
    private static int revertIndex(int index) {
        if (index == 0) {
            return index - 1;
        } else {
            return index - 2;
        }
    }
    
    private static String removeTwoEqualsChar(String cryptogram, final int index) {
        return cryptogram.substring(0, index) + cryptogram.substring(index + 2);
    }
    
    private static boolean isEqualsTwoChar(final char firstChar, final char secondChar) {
        return firstChar == secondChar;
    }
}
