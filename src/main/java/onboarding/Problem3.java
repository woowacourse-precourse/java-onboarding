package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;
        ArrayList<Character> charList = new ArrayList<Character>();

        for (int i=1; i<=number; i++) {
            String str = String.valueOf(i); // int -> string 변환

            // str -> charList 변환
            for (int j=0; j<str.length(); j++) {
                charList.add(str.charAt(j));
            }

            // 예를 들어, 36 이라는 숫자에는 박수 두 번
            for (Character character : charList) {
                if (character.equals('3') || character.equals('6') || character.equals('9')) {
                    cnt++;
                }
            }

            charList.clear();
        }

        return cnt;
    }
}
