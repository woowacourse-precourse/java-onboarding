package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        ArrayList<Integer> wordCase = new ArrayList<Integer>();
        ArrayList<Integer> chagneCase = new ArrayList<Integer>();

        // wordCase 리스트에 아스키코드의 정수 추가
        for (int i = 0; i < word.length(); i++) {
            wordCase.add((int) word.charAt(i));
        }

        // 65 이상 90 이하는 -65 , 97이상 122 이하는 -97 , 그 외 그대로 추가
        for (int i = 0; i < wordCase.size(); i++) {
            if (wordCase.get(i) >= 65 && wordCase.get(i) <= 90) {
                chagneCase.add((Math.abs((wordCase.get(i) - 65) - 25)) + 65);
            }
            if (wordCase.get(i) >= 97 && wordCase.get(i) <= 122) {
                chagneCase.add((Math.abs((wordCase.get(i) - 97) - 25)) + 97);
            }
            if (!(wordCase.get(i) >= 65 && wordCase.get(i) <= 90 || wordCase.get(i) >= 97 && wordCase.get(i) <= 122)) {
                chagneCase.add(wordCase.get(i));
            }
        }

        // 아스키코드를 문자열에 추가
        for (int i = 0; i < chagneCase.size(); i++) {
            answer += Character.toString(chagneCase.get(i));
        }

        return answer;
    }
}
