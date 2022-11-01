package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        // 예외사항 체크
        if (checkInvalid(cryptogram)) {
            return "제한사항 위반입니다.";
        }

        // 중복 문자를 찾지 못할 때까지 반복 순회
        while (true) {
            // 단어 순회하며 중복되는 문자들 인덱스 찾기
            List<Integer> index = traverseString(answer);
            if (index.isEmpty()) {
                // 중복문자 존재 X
                break;
            }
            // 중복 제거한 answer 갱신
            answer = deleteDuplicate(answer, index);
        }
        return answer;
    }

    // 예외 사항 체크하는 함수
    private static boolean checkInvalid(String answer) {
        // 예외 케이스
        if (answer.length() < 1 || answer.length() > 1000) {
            return true;
        }
        if (!answer.equals(answer.toLowerCase()) || !answer.matches("[a-z]+")) {
            return true;
        }
        return false;
    }

    // 문자열에서 인접한 중복 문자 인덱스를 반환하는 함수
    private static List<Integer> traverseString(String answer) {
        char[] chars = answer.toCharArray();
        Set<Integer> result = new HashSet<>();
        char prev = 0;
        int idx = -1;

        for (char ch : chars) {
            idx += 1;
            if (prev != ch) {
                prev = ch;
            } else {
                result.add(idx - 1);
                result.add(idx);
            }
        }

        // Set을 List로 바꾸어 반환
        return new ArrayList<>(result);
    }

    // 중복 문자를 제외한 새로운 문자열 반환하는 함수
    private static String deleteDuplicate(String answer, List<Integer> idxList) {
        String result = "";
        char[] chars = answer.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (!idxList.contains(i)) {
                result += chars[i];
            }
        }
        return result;
    }
}
