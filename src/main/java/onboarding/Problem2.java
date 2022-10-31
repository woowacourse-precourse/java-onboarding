package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        while (true) {
            answer = deleteConsecutiveCharacter(cryptogram);
            if (answer.equals(cryptogram)) {
                break;
            }
            cryptogram = answer;
        }
        return answer;
    }

    private static String deleteConsecutiveCharacter(String str) {
        String answer = "";
        char charToDelete = ' ';
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);

            if (now == charToDelete) {
                continue;
            }
            if (i == str.length() - 1) {
                answer += now;
                continue;
            }

            char next = str.charAt(i + 1);

            if (now != next) {
                answer += now;
                charToDelete = ' ';
                continue;
            }
            if (now == next) {
                charToDelete = now;
            }
        }
        return answer;
    }
}

/* 구현 로직
 * 1. 문자열을 앞에서부터 탐색한다.
 *   1-1. 문자열이 delete와 같다면 바로 다음으로 넘어간다.
 *   1-2. 문자열이 마지막에 도착했으면 그냥 넣어준다.
 *   1-3. 다음 문자열을 찾아서 비교한다.
 *       1-3-1. 다르다면 지금 문자열을 새 문자열에 넣어주고 delete를 초기화해준다.
 *       1-3-2. 같아면 delete = 지금 문자열로 지정하고 다음으로 넘어간다.
 * 2. 1번 과정을 문자열의 변화가 생기지 않을때까지 반복한다.
 * */

/* 기능 목록
 * 1. 문자열을 탐색해서 중복을 없애주는 메소드
 * */