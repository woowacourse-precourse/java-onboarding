package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String[] word_array;
        word_array = cryptogram.split("");
        List<String> word_list = new ArrayList<>(Arrays.asList(word_array));

        // while 문을 멈출 트리거
        boolean flag = true;
        String answer = "";

        // for문을 돌아서 연속된 중복된 값이 있다면 temp에 저장.
        while (flag) {
            boolean check = false;
            int temp = 0;
            for (int i = 0; i < word_list.size()-1; i++) {
                if(word_list.get(i).equals(word_list.get(i+1))) {
                    temp = i;
                    check = true;
                    break;
                }
            }

            // check가 false라면 아무런 중복값없이 for문이 끝남
            // check가 있다면 연속된 반복 알파벳을 모두 삭제
            // 여기서 매우 틀림...
            if (check) {
                while(temp < word_list.size()-1 && word_list.get(temp).equals(word_list.get(temp+1))) {
                    word_list.remove(temp + 1);
                }
                word_list.remove(temp);
            } else {
                flag = false;
            }
        }

        for (int i = 0; i < word_list.size(); i++) {
            answer += word_list.get(i);
        }
        return answer;
    }
}
