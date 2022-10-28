package onboarding;


import onboarding.problem1.Comparator;

import java.util.List;

import static onboarding.problem1.Comparator.getBigger;
import static onboarding.problem1.Comparator.getWinner;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;



        // 페이지 펼칠 때 예외 상황
        if (runtimeException(pobi) || runtimeException(crong)) answer = -1;
        // 정상 흐름으로 제어권 이동
        else {
            // 왼쪽 페이지, 오른쪽 페이지 각 자리수 더하기, 곱하기
            int pobiAddLeft = getEachNumberBySum(pobi.get(0));
            int pobiAddRight = getEachNumberBySum(pobi.get(1));

            int pobiMultiplyLeft = getEachNumberByMultiply(pobi.get(0));
            int pobiMultiplyRight = getEachNumberByMultiply(pobi.get(1));

            int crongAddLeft = getEachNumberBySum(crong.get(0));
            int crongAddRight = getEachNumberBySum(crong.get(1));

            int crongMultiplyLeft = getEachNumberByMultiply(crong.get(0));
            int crongMultiplyRight = getEachNumberByMultiply(crong.get(1));


            // 포비, 크롱 각자 왼쪽과 오른쪽 페이지 비교값
            int pobiAddMax = getBigger(pobiAddLeft, pobiAddRight);
            int pobiMultiplyMax = getBigger(pobiMultiplyLeft, pobiMultiplyRight);
            int crongAddMax = getBigger(crongAddLeft, crongAddRight);
            int crongMultiplyMax = getBigger(crongMultiplyLeft, crongMultiplyRight);

            // 포비, 크롱 최대값
            int pobiMax = getBigger(pobiAddMax, pobiMultiplyMax);
            int crongMax = getBigger(crongAddMax, crongMultiplyMax);

            // 게임의 승자 구하기
            answer = getWinner(pobiMax, crongMax);

        }
        return answer;
    }

    // 에러 검증
    public static boolean runtimeException(List<Integer> pageByPlayer) {
        //given
        int leftNumber = pageByPlayer.get(0);
        int rightNumber = pageByPlayer.get(1);

        //when
        if (leftNumber < 1 || rightNumber >= 400
                || rightNumber - leftNumber > 1) {
            return true;
        } else {
            //then
            return false;
        }
    }



    public static Integer getEachNumberBySum(int pageNumber) {
        int eachNumber = 0; // 중복 x 지점
        while (pageNumber != 0 && pageNumber != 400) {
            eachNumber += pageNumber % 10;
            pageNumber /= 10;
        }

        return eachNumber;
    }

    public static Integer getEachNumberByMultiply(Integer pageNumber) {
        int eachNumber = 1; // 중복 x 지점
        while (pageNumber != 0 && pageNumber != 400) {
            eachNumber *= pageNumber % 10;
            pageNumber /= 10;
        }
        return eachNumber;
    }
}


