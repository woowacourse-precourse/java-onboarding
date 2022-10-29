package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    static List<Character> list = new ArrayList<>();

    /**
     * 문자열을 Character형 List로 변환하는 메서드
     *
     * @param cryptogram 입력받는 문자열
     * @return List로 바꾼 문자열
     */
    static List<Character> transStringToList(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            list.add(cryptogram.charAt(i));
        }

        return list;
    }

    /**
     * 연속적으로 중복되는 문자을 삭제하는 메서드
     *
     * @return 문자가 삭제 되었으면 true, 아니라면 false
     */
    static boolean deleteDuplicateChar() {
        int index = 0;
        boolean isDeleted = false;

        while (index != list.size()) {
            if (list.get(index).equals(list.get(index + 1))) {
                list.remove(index);
                list.remove(index + 1);
                isDeleted = true;
            }
            else {
                index++;
            }
        }

        return isDeleted;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
