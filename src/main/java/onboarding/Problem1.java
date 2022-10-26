package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;



        return answer;
    }

    // 각 자리수를 구한다.
    public static List<Integer> getEachDigit(int page) {
        List<Integer> pageDigitList = new ArrayList<>();
        while(page > 0){
            pageDigitList.add(page % 10);
            page /= 10;
        }
        return pageDigitList;
    }

    // 각 자리수의 합을 구한다.
    public static int getAdditionTotal(List<Integer> pageDigitList) {
        int answer = 0;
        for (int i = 0; i < pageDigitList.size(); i++) {
            answer += pageDigitList.get(i);
        }
        return answer;
    }

    // 각 자리수의 곱을 구한다.
    public static int getMultiplicationTotal(List<Integer> pageDigitList) {
        int answer = 1;
        for (int i = 0; i < pageDigitList.size(); i++) {
            answer *= pageDigitList.get(i);
            if(answer == 0) {
                return 0;
            }
        }
        return answer;
    }


    // 구한 값 중 최댓값을 구한다.
    // 예외 처리 체크
    public boolean checkValidValue(List<Integer> user) {
        int leftPage = user.get(0);
        int rightPage = user.get(1);

        if (rightPage - leftPage != 1) {
            return false;
        }
        if (leftPage == 1 || rightPage == 400) {
            return false;
        }
        return true;
    }
}