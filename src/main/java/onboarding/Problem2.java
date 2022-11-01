package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] stack = new char[cryptogram.length()];
        int i = 0;

        for (int j = 0; j < cryptogram.length(); j++) {
            char currentChar = cryptogram.charAt(j);

            if (i >0 && stack[i-1] == currentChar) {
                i--;
            } else {
                stack[i] = currentChar;
                i += 1;
            }
        }
        return new String(stack, 0, i);
    }
}
