package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {

        char[] charArray = cryptogram.toCharArray();
        ArrayList<Character> charArrayList = new ArrayList<Character>();
        for (char a : charArray) {
            charArrayList.add(a);
        }
        boolean isExist = true;

        A:
        do {
            for (int i = 0; i < charArrayList.size() - 1; i++) {
                if (charArrayList.get(i) == charArrayList.get(i + 1)) {
                    charArrayList.remove(i);
                    charArrayList.remove(i);
                    continue A;
                }
            }
            isExist = false;
        } while (isExist);

        String answer = "answer";
        return answer;
    }
}
