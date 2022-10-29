package onboarding;

import java.util.ArrayList;

public class Problem2 {

    static ArrayList<Character> separateString(String cryptogram) {
        ArrayList<Character> cryptoArray = new ArrayList<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            cryptoArray.add(cryptogram.charAt(i));
        }

        return cryptoArray;
    }

    static Boolean checkDuplication(ArrayList<Character> separatedCrypto) {
        for (int i = 1; i < separatedCrypto.size(); i++) {
            if (separatedCrypto.get(i) == separatedCrypto.get(i - 1)) {
                return true;
            }
        }
        return false;
    }

    static ArrayList<Character> deleteDuplication(ArrayList<Character> separatedCrypto) {

        for (int i = 1; i < separatedCrypto.size(); i++) {
            if (separatedCrypto.get(i) == separatedCrypto.get(i - 1)) {
                separatedCrypto.remove(i - 1);
                separatedCrypto.remove(i - 1);
            }
        }

        return separatedCrypto;
    }

    static String makeString(ArrayList<Character> separatedCrypto) {
        String crypto = "";

        for (char x: separatedCrypto) {
            crypto += x;
        }

        return crypto;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        ArrayList<Character> separatedCrypto = separateString(cryptogram);

        while(checkDuplication(separatedCrypto)) {
            separatedCrypto = deleteDuplication(separatedCrypto);
        }

        answer = makeString(separatedCrypto);

        return answer;
    }
}
