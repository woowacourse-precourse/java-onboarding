package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {

        if (throwBoundaryException(cryptogram)) {
            return "failed with boundary exception";
        }

        if (throwCapitalException(cryptogram)) {
            return "failed with capital exception";
        }

        while (isContinuous(cryptogram)) {
            cryptogram = removeContinuousLetter(cryptogram);
        }


        return cryptogram;
    }

    public static Boolean throwBoundaryException(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return true;
        }
        return false;
    }

    public static Boolean throwCapitalException(String cryptogram) {
        char[] charArray = cryptogram.toCharArray();
        int index;

        for (index = 0; index < charArray.length; index++) {
            if (Character.isUpperCase(charArray[index])) {
                return true;
            }
        }
        return false;
    }

    public static Boolean isContinuous(String cryptogram) {
        char[] charArray = cryptogram.toCharArray();
        char prev = '!';
        int index;

        for (index = 0; index < charArray.length; index++) {
            if (prev != charArray[index]) {
                prev = charArray[index];
                continue;
            }

            if (prev == charArray[index]) {
                return true;
            }
        }
        return false;
    }

    public static String removeContinuousLetter(String cryptogram) {
        char[] charArray = cryptogram.toCharArray();
        ArrayList<Character> newCharArray= new ArrayList<>();
        String joinedCharArray;
        char prev = '!';
        int index;

        for(index = 0; index < charArray.length; index++) {
            if (prev != charArray[index]) {
                prev = charArray[index];
                newCharArray.add(charArray[index]);
                continue;
            }

            if (prev == charArray[index]) {
                newCharArray.remove(newCharArray.size() - 1);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(char ch : newCharArray){
            sb.append(ch);
        }

        joinedCharArray = sb.toString();

        return joinedCharArray;
    }
}
