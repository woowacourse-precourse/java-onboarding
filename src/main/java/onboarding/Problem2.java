package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem2 {
    // String을 List로 변환하는 함수
    public static List<Character> transform_list(String cryptogram) {
        List<Character> cryptolist = new ArrayList<Character>();

        char[] cryparray = cryptogram.toCharArray();
        for (char c : cryparray) {
            cryptolist.add(c);
        }

        return cryptolist;
    }

    // List의 중복 문자들을 제거하는 함수
    public static List<Character> remove_duplicate(List<Character> list) {
        List<Character> remove_dupicate_list = list;

        for (int i = 0; i < remove_dupicate_list.size() - 1; i++) {
            if (remove_dupicate_list.size() == 1) {
                break;
            }

            if (remove_dupicate_list.get(i) == remove_dupicate_list.get(i + 1)) {
                int temp_index = i;
                int duplicate_count = 1;

                while (remove_dupicate_list.get(temp_index) == remove_dupicate_list.get(temp_index + 1)) {
                    temp_index += 1;
                    duplicate_count += 1;
                    if (temp_index + 1 == remove_dupicate_list.size()) {
                        break;
                    }
                }

                for (int count = 0; count < duplicate_count; count++) {
                    remove_dupicate_list.remove(i);
                }

                i = i - 2;

                if (i == -2) {
                    i = i + 1;
                }
            }
        }

        return remove_dupicate_list;
    }

    // 작동 함수
    public static String solution(String cryptogram) {
        String answer = "answer";

        List<Character> cryptolist = transform_list(cryptogram);

        List<Character> remove_duplicate_list = remove_duplicate(cryptolist);

        String temp_answer = "";
        for (char alphabet : remove_duplicate_list) {
            temp_answer += alphabet;
        }

        answer = temp_answer;

        return answer;
    }
}
