package onboarding;

import java.util.List;

class Problem1 {
    /*
    - 문제 요구사항 정리 및 해결방법
    1. pobi와 crong의 예외처리
        - pobi와 crong의 페이지 번호가 정의에 안 맞거나 범위를 벗어나거나, 순서가 안맞을 경우 예외처리
        - 예외 발생시 → -1을 리턴
    2. pobi와 crong마다 최대값을 구함
        - pobi(또는 crong)가 펼친 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구함
        - pobi(또는 crong)가 펼친 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수 를 구함
        - pobi(또는 crong)가 구한 왼쪽 페이지의 가장 큰 값과 오른쪽 페이지의 가장 큰값중 가장 큰 값을 구하여 pobi(또는 crong)의 최대값을 구함
    3. pobi와 crong의 최대값과 비교 및 예외사항을 적용하여 아래의 조건을 성립하도록 결과 리턴
        - 포비가 이긴 경우 → 1을 리턴
        - 크롱이 이긴 경우 → 2를 리턴
        - 무승부시 → 3을 리턴
    */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}