package onboarding;

import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer =  process(cryptogram);
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
    static boolean repeat_finish(String word) {
        boolean[] finish = repeat_word_check(word);

        for (int i = 0; i < finish.length; i++) {
            if (finish[i] == true) {
                return false;
            }
        }
        return true;
    }

    //단어의 중복을 제거하고 새로운 단어를 생성하는 함수

    static String new_word(String word) {
        boolean[] guide_line = repeat_word_check(word);

        String tmp = "";
        for (int i = 0; i < guide_line.length; i++) {
            if (!guide_line[i]) {
                tmp += String.valueOf(word.charAt(i));
            }
        }

        return tmp;
    }
    //실행을 위한 함수

    static String process(String word) {

        while (!repeat_finish(word)) {
            word = new_word(word);

        }
        return word;
    }
}

