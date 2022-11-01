package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {

    public static String solution(String cryptogram) {
        String cleaned_cryptogram = "";

        while (true) {
            cleaned_cryptogram = remove_duplication_from(cryptogram);

            if (cleaned_cryptogram.equals(cryptogram)){
                break;
            }

            cryptogram = cleaned_cryptogram;
        }

        return cleaned_cryptogram;
    }

    public static String remove_duplication_from(String cryptogram) {
        int length = cryptogram.length();

        if (length == 0){
            return "";
        }

        Deque<Character> dq = new ArrayDeque<>();
        dq.addLast(cryptogram.charAt(0));

        Character prev = cryptogram.charAt(0);

        for (int i=1; i < length; i++) {
            Character curr = cryptogram.charAt(i);

            if (prev == curr){
                if (dq.peekLast() == curr) {
                    dq.removeLast();
                }
            } else {
                dq.addLast(curr);
            }

            prev = curr;
        }


        String result = "";
        while (!dq.isEmpty()){
            result += dq.removeFirst();
        }

        return result;

    }


}
