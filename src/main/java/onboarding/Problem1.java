package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.get(0) == 1 || crong.get(0) == 1 || pobi.get(1) == 400 || crong.get(1) == 400
                || (pobi.get(0) + 1 != pobi.get(1)) || (crong.get(0) + 1 != crong.get(1))
                || pobi.get(0) % 2 != 1 || (crong.get(0) % 2 != 1))) // 예외사항 처리 따로 처리
            return (-1);

        int pobiMax = findMax(pobi); // 최대값을 찾는 함수를 만들어 포비, 크롱의 좌, 우, 덧셈, 곱셈 중 큰 값을 찾자
        int crongMax = findMax(crong);

        if (pobiMax == crongMax)
            return (0);
        return (pobiMax > crongMax ? 1 : 2);
    }
}