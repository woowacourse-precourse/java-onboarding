package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMax = findMax(pobi); // 최대값을 찾는 함수를 만들어 포비, 크롱의 좌, 우, 덧셈, 곱셈 중 큰 값을 찾자
        int crongMax = findMax(crong);

        if (pobiMax == crongMax)
            return (0);
        return (pobiMax > crongMax ? 1 : 2);
    }
}