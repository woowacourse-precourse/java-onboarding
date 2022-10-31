package onboarding;

import java.util.Vector;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer = decoder(cryptogram);
    }

    //크립토그램을 해석하는 함수
    public static String decoder(String word) {
        Vector<Character> answerVector = new Vector<Character>();
        String decorded = "";
        for (char c : word.toCharArray()) {
            answerVector = isAddable(answerVector, c);
        }
        for (char c : answerVector) {
            decorded += c;
        }
        return decorded;
    }

    //정답 문자열에 추가될 수 있는지 확인하는 함수
    public static Vector<Character> isAddable(Vector<Character> vector, char c) {
        if (vector.size() != 0 && vector.get(vector.size() - 1).equals(c)) {
            vector.remove(vector.size() - 1);
        } else {
            vector.add(c);
        }
        return vector;
    }
}