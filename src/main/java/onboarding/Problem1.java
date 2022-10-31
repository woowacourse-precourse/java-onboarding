package onboarding;

import java.util.Collections;
import java.util.List;

/**
 * @작성자 rjsah09
 * @작성일 2022.10.31
 *
 * @수정내역
 * 2022.10.31 13.05 : 테스트 확인 및 isConstant(), mul() 수정
 * */

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //데이터 이상 감지
        if (!isConstant(pobi) || !isConstant(crong)) {
            return -1;
        }

        //각자의 가장 큰 수 구하기
        int pobiMax = getMax(pobi);
        int crongMax = getMax(crong);

        //큰 수에 따른 결과 저장
        answer = getAnswer(pobiMax, crongMax);

        return answer;
    }

    //데이터 이상 여부 체크
    private static boolean isConstant(List<Integer> list) {
        int size = list.size();
        int diff = Math.abs(list.get(0) - list.get(1));
        int min = Collections.max(list);
        int max = Collections.min(list);

        //1차 constant 확인
        if(size != 2 || diff != 1 || min < 1 || max > 400) {
            return false;
        }

        int odd = list.get(0);
        int even = list.get(1);

        //2차 constant 확인
        if(odd % 2 != 1 || even % 2 != 0) {
            return false;
        }

        return true;
    }

    //페이지 덧셈
    private static int sum(int n) {
        int result = 0;

        while(n > 0) {
            result += n % 10;
            n /= 10;
        }

        return result;
    }

    //페이지 곱셈
    private static int mul(int n) {
        int result = 1;

        while(n > 0) {
            result *= n % 10;
            n /= 10;
        }

        return result;
    }

    //큰 수 반환
    private static int getMax(List<Integer> list) {
        int result = 0;

        for(int n: list) {
            int sum = sum(n);
            int mul = mul(n);
            int max = Math.max(sum, mul);
            result = Math.max(result, max);
        }

        return result;
    }

    private static int getAnswer(int n1, int n2) {
        if (n1 > n2) {
            return 1;
        } else if (n1 < n2) {
            return 2;
        } else {
            return 0;
        }
    }

}