package onboarding;

import java.util.HashSet;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (cryptogram.length() == 1) {
            return cryptogram;
        }
        String answer = Decryptor.decrypt(cryptogram);
        return answer;
    }
}


class Decryptor {
    private static String checkNeighbors(char prevChar,char presentChar, char nextChar) {
        if (prevChar != presentChar && presentChar != nextChar) {
            return presentChar + "";
        }
        return "";
    }

    private static String checkNeighbors(char thisChar,char compareChar) {
        if (thisChar != compareChar) {
            return thisChar + "";
        }
        return "";
    }

    private static StringBuilder deleteDuplicateChars(StringBuilder crypto) {
        StringBuilder result = new StringBuilder("");

        result.append(checkNeighbors(crypto.charAt(0), crypto.charAt(1)));
        for (int i = 1; i < crypto.length() - 1; i++) {
            result.append(checkNeighbors(crypto.charAt(i - 1), crypto.charAt(i), crypto.charAt(i + 1)));
        }
        result.append(checkNeighbors(crypto.charAt(crypto.length() - 1), crypto.charAt(crypto.length() - 2)));
        return result;
    }

    static String decrypt(String input) {
        StringBuilder newStr = new StringBuilder(input);
        StringBuilder resultStr = new StringBuilder("");

        while (newStr.length() != 0 && newStr.compareTo(resultStr = deleteDuplicateChars(newStr)) != 0) {
            newStr = resultStr;
        }
        return resultStr.toString();
    }

}
