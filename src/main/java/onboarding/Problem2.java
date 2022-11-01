package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    /**
     * 문자열을 Character형 List로 변환하는 메서드
     *
     * @param cryptogram 입력받는 문자열
     * @return List로 바꾼 문자열
     */
    static List<Character> transStringToList(String cryptogram) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            list.add(cryptogram.charAt(i));
        }

        return list;
    }

    /**
     * List를 String으로 변환하는 메서드
     *
     * @param inputList String으로 바꿀 List ,static 변수 list가 들어간다
     * @return String으로 바꾼 List
     */
    static String transListToString(List<Character> inputList) {
        String str = "";

        for (int i = 0; i < inputList.size(); i++) {
            str += inputList.get(i);
        }

        return str;
    }

    /**
     * 연속적으로 중복되는 문자을 삭제하는 메서드
     *
     * @return 문자가 삭제 되었으면 true, 아니라면 false
     */
    static boolean deleteDuplicateChar(List<Character> inputList) {
        int index = 0;
        boolean isDeleted = false;

        while (index != (inputList.size() - 1)) {
            if (inputList.get(index).equals(inputList.get(index + 1))) {
                inputList.remove(index + 1);
                inputList.remove(index);
                isDeleted = true;
            } else {
                index++;
            }

            if (inputList.size() == 0) {
                return false;
            }
        }

        return isDeleted;
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        List<Character> cryptogramList;
        boolean isDeleted = true;

        cryptogramList = transStringToList(answer);
        while (isDeleted) {
            isDeleted = deleteDuplicateChar(cryptogramList);
        }

        answer = transListToString(cryptogramList);
        return answer;
    }
}
