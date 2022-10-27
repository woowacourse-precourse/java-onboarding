package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외 체크
        if (exceptionChk(pobi, crong)) return -1;

        // 책 펼쳐서 점수 얻기
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        // 점수 비교
        if (pobiScore > crongScore) return 1;
        else if (pobiScore < crongScore) return 2;
        else return 0;
    }

    // 각 플레이어의 점수를 가져오는 메소드
    public static int getScore(List<Integer> list) {
        int page;
        int max = 0;
        int score;
        List<Integer> nums;
        for (int i = 0; i < 2; i++) {
            // 페이지 가져오기
            page = list.get(i);
            // 자리수 나누기
            nums = new ArrayList<>();
            getNum(page, nums);
            // 더하기
            score = 0;
            for (Integer num : nums) score += num;
            if (max < score) max = score;
            // 곱하기
            score = 1;
            for (Integer num : nums) score *= num;
            if (max < score) max = score;
        }
        return max;
    }

    // 자리수 나누는 메소드
    public static void getNum (int page, List<Integer> nums) {
        int n;
        while (page > 0) {
            n = page % 10;
            page /= 10;
            nums.add(n);
        }
    }

    // 예외 체크하는 메소드
    public static boolean exceptionChk(List<Integer> pobi, List<Integer> crong) {
        // 발생하면 안되는 상황이 하나라도 발생하면 예외
        return pobi.get(0) + 1 != pobi.get(1)
                || crong.get(0) + 1 != crong.get(1)
                || pobi.get(0) == 1 || crong.get(0) == 1
                || pobi.get(1) == 400 || crong.get(1) == 400;
    }
}