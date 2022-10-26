package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
* 1. 결과 비교를 위한 변수 생성.
* 2. pobi와 crong의 index에 접근해서 index 값 잘라서 더하기, 곱하기 후 1번에서 생성한 변수에 저장.
* 3. 값 비교 후 answer에 요구 사항 조건에 따라 값 저장.
* */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiSumLeft = 0;
        int pobiMulLeft = 1;
        int pobiSumRight = 0;
        int pobiMulRight = 1;
        int pobiCompareLeft = 0;
        int pobiCompareRight = 0;
        int pobiResult = 0;

        int crongSumLeft = 0;
        int crongMulLeft = 1;
        int crongSumRight = 0;
        int crongMulRight = 1;
        int crongCompareLeft = 0;
        int crongCompareRight = 0;
        int crongResult = 0;

        int answer = Integer.MAX_VALUE;

        return answer;
    }
}