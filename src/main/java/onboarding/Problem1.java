package onboarding;

import java.util.List;

class Problem1 {
    private static boolean checkException(int prev, int next){
        // 쪽수에 대한 예외처리
        return (prev + 1 == next);
    }

    private static int getMaxValue(int num){
        // 시작 페이지이거나 마지막 페이지에 대한 예외처리
        if(num < 3 || num > 389) return -1;
        // 합과 곱에 대한 연산
        int sum = 0, mul = 1;
        for(; num > 0; num /= 10){
            sum += num % 10;
            mul *= num % 10;
        }
        // 합, 곱 대소비교 후 반환
        return (sum > mul ? sum : mul);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!checkException(pobi.get(0), pobi.get(1)) || !checkException(crong.get(0), crong.get(1)))
            return -1;

        int pobi_score, crong_score;
        pobi_score = Math.max(getMaxValue(pobi.get(0)), getMaxValue(pobi.get(1)));
        crong_score = Math.max(getMaxValue(crong.get(0)), getMaxValue(crong.get(1)));

        if(pobi_score < 0 || crong_score < 0) return -1;
        else if(pobi_score == crong_score) return 0;
        else if(pobi_score > crong_score) return 1;
        return 2;
    }
}