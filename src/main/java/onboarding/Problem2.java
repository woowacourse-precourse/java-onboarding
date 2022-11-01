package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        ArrayList<Character> cryptoList = new ArrayList<Character>();
        char[] cryptoArray = cryptogram.toCharArray();
        for (char c : cryptoArray) {
            cryptoList.add(c);
        }

        for (int i=0; i<cryptoList.size() -1 ; i++) {
            if (cryptoList.get(i) == cryptoList.get(i+1)) {
                cryptoList.remove(i);
                cryptoList.remove(i);
                i = -1;
            }
        }

        answer = "";
        for (char ch : cryptoList) {
            answer += ch;
        }
        return answer;
    }
}
