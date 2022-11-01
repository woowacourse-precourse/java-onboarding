package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        int currentLength;
        do {
            currentLength = cryptogram.length();
            cryptogram = removeDuplication(cryptogram);
        } while (currentLength != cryptogram.length());

        return cryptogram;
    }

    public static String removeDuplication(String temp) {
        char current = ' ';
        for (int i = 0; i < temp.length(); i++) {
            if (current != temp.charAt(i)) {
                current = temp.charAt(i);
            } else {
                temp = temp.replace(current + String.valueOf(current), "");
            }
        }
        return temp;
    }
}
