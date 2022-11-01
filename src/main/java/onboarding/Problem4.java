package onboarding;

public class Problem4 {
    /*
    - 문제 요구사항 정리 및 해결방법
    1. 주어진 문자열을 문제에 나와있는 규칙대로 변경하여 변경 후 문자열 리턴
        - 알파벳 a, 알파벳 z, 알파벳 A, 알파벳 Z는 10진수로 표현했을 때, 각각 유니코드 기준  97, 122,  65, 90임
        - 뛰어쓰기는 10진수로 표현했을 때, 유니코드 기준 32임
        - 소문자와 대문자 나눠서 코드 진행
        - 주어진 문자가 소문자라면, 소문자 a와 주어진 문자의 거리를 122(소문자 z의 10진수)에서 빼면 문제의 규칙에 적합한 문자의 10진수를 얻을수 있음
        - 주어진 문자가 대문자라면, 대문자 A와 주어진 문자의 거리를 90(대문자 Z의 10진수)에서 빼면 문제의 규칙에 적합한 문자의 10진수를 얻을수 있음
     */
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
