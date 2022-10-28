package onboarding;

import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static List<Integer> reapeatedNum(String cryptogram) {
        // 중복 문자 체크를 위한 변수 선언
        int hasRepeatedNum = -1;
        int beginRepeatedNum = -1;
        int endRepeatedNum = -1;

        // 중복 문자 유무 확인
        boolean checkFirst = true;

        char beforeChar = cryptogram.charAt(0);
        for (int i = 1; i < cryptogram.length(); i++) {
            char nowChar = cryptogram.charAt(i);

            if (nowChar == beforeChar && checkFirst) {
                // 중복 문자 처음 발견 시 시작 지점 저장
                hasRepeatedNum = 1;
                beginRepeatedNum = i - 1;
                checkFirst = false;
            } else if ((nowChar != beforeChar) && !checkFirst) {
                // 중복 문자 발견 및 연결된 문자 다를 시 끝 지점 저장
                endRepeatedNum = i - 1;
                break;
            } else if ((i == cryptogram.length() - 1) && !checkFirst) {
                // 중복 문자 발견 및 문자열 끝까지 탐색 완료 시 끝 지점 저장
                endRepeatedNum = i;
                break;
            }
            beforeChar = nowChar;
        }

        return List.of(hasRepeatedNum, beginRepeatedNum, endRepeatedNum);
    }
}
