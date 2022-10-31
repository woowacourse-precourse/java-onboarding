package onboarding;

import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    //입력으로 주어지는 단어에 중복되는 구간값을 체크해주는 함수

    static boolean[] repeat_word_check(String word) {

        boolean[] check = new boolean[word.length()];
        Arrays.fill(check, false);

        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) != word.charAt(i + 1)) continue;

            if (word.charAt(i) == word.charAt(i + 1)) {
                check[i] = true;
                check[i + 1] = true;
                i++;
            }
        }

        return check;
    }

    //입력으로 주어진 단어에 중복이 있는지 없는지 확인하는 함수

    //단어의 중복을 제거하고 새로운 단어를 생성하는 함수

    //실행을 위한 함수

}

