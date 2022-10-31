package onboarding;

import java.util.Vector;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
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