package onboarding;

import java.util.ArrayList;
import java.util.List;

// 1~400페이지의 책
// 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수

// 홀수 각 자리의 숫자를 전부 더한 수, 전부 곱한 수,
// 짝수 각 자리의 숫자를 전부 더한 수, 전부 곱한 수
// 이렇게 4가지의 수 중 가장 큰 수를 본인의 점수로 한다

// 점수를 비교해 가장 높은 사람이 게임의 승자
// 시작 면이나 마지막 면이 나오지 않도록 한다

// 위 과정을 포비와 크롱에게 적용
// 포비와 크롱의 점수를 비교한다.

// todo
// 1. pobi와 crong리스트 안에 들어있는 숫자를 가져온다.
// 2. 가져온 숫자 각각의 자릿수를 분해

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_first = pobi.get(0);
        int pobi_second = pobi.get(1);

        int crong_first = crong.get(0);
        int crong_second = crong.get(1);

        return answer;
    }
}