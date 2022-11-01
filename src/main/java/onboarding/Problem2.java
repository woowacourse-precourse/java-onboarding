package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;

        // 4.더 이상 제거할 문자가 없을때까지 반복하는 while문
        while(true) {
            answer = deleteSameCharacter(cryptogram);
            if(answer.equals(cryptogram)) {
                break;
            }
            cryptogram = answer;
        }
        return answer;
    }

    // 2.연속된 문자가 같은 문자일때까지 제거하는 함수
    private static String deleteSameCharacter(String str) {
        String imsi = "";
        char charToDelete = ' ';

        // 3. 문자의 처음부터 끝까지 검사하는 반복문
        for(int i = 0; i < str.length(); i++) {
            char now = str.charAt(i); // 현재 인덱스의 문자를 저장할 변수 now

            if(now == charToDelete) {
                continue;
            }

            // 현재 인덱스가 마지막일 경우
            if(i == str.length() - 1) {
                imsi += now;
                continue;
            }

            char next = str.charAt(i + 1); // 비교를 할 다음 문자

            // 연속으로 같은 글자가 아닐 경우
            if(now != next) {
                imsi += now;
                charToDelete = ' '; // 초기화
                continue;
            }

            if(now == next) {
                charToDelete = now;
            }
        }
        return imsi;
    }
}
