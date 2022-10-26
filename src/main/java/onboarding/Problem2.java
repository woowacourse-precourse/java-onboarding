package onboarding;

// <기능 목록>
// 1. 암호문 해독
//  a. cipher(n) == cipher(n+1)일 때까지 탐색
//  b. cipher(n) != cipher(n+m)일 때까지 탐색
//  c. cipher(n) ~ cipher(n+m-1)을 제거한 문장으로 cipher 초기화
//  d. cipher(n+1)부터 다시 탐색 시작 -> 문장이 끝날때까지
// 2. 1번 반복
//  반복문 break 조건 : 연속하는 중복문자가 없었을 때, string length < 2

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
