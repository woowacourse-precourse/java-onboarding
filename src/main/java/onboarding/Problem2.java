package onboarding;

import java.util.LinkedList;
import java.util.Queue;

import onboarding.problem2.CheckCrytogram;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (CheckCrytogram.of(cryptogram)) {

        }
        Queue<Character> resultList = new LinkedList<>();
        char[] cryptogramChars = cryptogram.toCharArray();
        int n = cryptogramChars.length;
        int index = 0;
        String answer = "answer";
        return answer;
    }


}
