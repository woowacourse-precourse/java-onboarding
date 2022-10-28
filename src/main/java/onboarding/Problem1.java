package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        /*
        조건 0 : 페이지 수의 범위는 1~400 이다.
        조건 1 : 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호
        조건 2 : 모든 페이지에는 번호가 적혀있다
        조건 2-1 :
        왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        위의 과정에서 가장 큰 수를 본인의 점수로 한다.
        조건 3 : 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return
         */

        //유효성 확인 메서드 구현
        if (isFail(pobi) || isFail(crong)) {
            answer = -1;
            return answer;
        }

        // 최댓값 만들기 메서드 구현
        int pobi_max = makeMax(pobi);
        int crong_max = makeMax(crong);

        // 최댓값 비교 구현
        if (pobi_max > crong_max) {
            answer = 1;
        } else if (pobi_max < crong_max) {
            answer = 2;
        } else if (pobi_max == crong_max) {
            answer = 0;
        }
        return answer;
    }

    private static boolean isFail(List<Integer> user) {
        //유효성 검사
        boolean result = false;

        // list.get(0) = 홀수 && list.get(1) = 짝수;
        // list.get(0)+1 = list.get(1);
        // list.get(0)>=1 && list.get(1) <= 400;
        if (!(user.get(0) % 2 == 1 && user.get(1) % 2 == 0)) {
            result = true;
        }
        if (!(user.get(0) + 1 == user.get(1))) {
            result = true;
        }
        if (!(user.get(0) >= 1 && user.get(1) <= 400)) {
            result = true;
        }
        return result;
    }

    private static int makeMax(List<Integer> user) {
        int maxNum = 0;
        for (int i = 0; i < user.size(); i++) {
            maxNum = Math.max(maxNum, makeMaxNum(String.valueOf(user.get(i))));
        }
        return maxNum;
    }

    private static int makeMaxNum(String num) {
        int numAdd = 0;
        int numMul = 1;

        for (int i = 0; i < num.length(); i++) {
            numAdd += Integer.parseInt(String.valueOf(num.charAt(i)));
            numMul *= Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return Math.max(numAdd, numMul);
    }

}