package onboarding;

import java.util.LinkedList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        while (checkDuplication(cryptogram)) {
            cryptogram = removeDuplication(cryptogram);
        }
        answer = cryptogram;
        return answer;
    }


    private static boolean checkDuplication(String str) {
        for (int i = 0; i <str.length() -1; i++)
            if (str.charAt(i) == str.charAt(i + 1)) {
                return true;
            }
        return false;
    }

    private static String removeDuplication(String str) {

        Stack<Integer> storage = new Stack<>();
        LinkedList<Character> list = new LinkedList<>();

        for(int i = 0; i < str.length(); i++)
            list.add(str.charAt(i));

        for(int i = 0; i < str.length() - 1; i++)
            if (str.charAt(i) == str.charAt(i + 1)) {
                storage.push(i);
                storage.push(i + 1);
                i += 1;
            }

        for (int i = storage.size(); i >= 1; i--) {
            list.remove(storage.pop().intValue());
        }

        String temp = "";
        for (Character character : list) {
            temp += character;
        }

        return temp;
    }
}
