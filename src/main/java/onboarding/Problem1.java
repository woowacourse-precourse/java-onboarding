package onboarding;

import java.util.List;

/*
##기능 목록##

1. 각 List의 index 0, 1이 각각 홀수, 짝수 인지 확인
2. 각 List의 index 0, 1이 연속된 수 인지 확인
3. 각 List의 index 0으로 만들 수 있는 최대 값 구하기
4. 각 List의 index 1로 만들 수 있는 최대 값 구하기
5. 각 List의 index 0, 1로 만들 수 있는 최대 값 구하기
6. 최대 값 비교 후 결과 출력
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeftPageNumber = pobi.get(0), pobiRightPageNumber = pobi.get(1);
        int crongLeftPageNumber = crong.get(0), crongRightPageNumber = crong.get(1);


        if (!isOdd(pobiLeftPageNumber) || isOdd(pobiRightPageNumber) || !isOdd(crongLeftPageNumber) || isOdd(crongRightPageNumber)) {
            answer = -1;
            return answer;
        }

        if (!isContinuous(pobiLeftPageNumber, pobiRightPageNumber) || !isContinuous(crongLeftPageNumber, crongRightPageNumber)) {
            answer = -1;
            return answer;
        }

        int pobiLeftMaxValue = Math.max(getSumMax(pobiLeftPageNumber),getMulMax(pobiLeftPageNumber));
        int pobiRightMaxValue = Math.max(getSumMax(pobiRightPageNumber),getMulMax(pobiRightPageNumber));
        int crongLeftMaxValue = Math.max(getSumMax(crongLeftPageNumber),getMulMax(crongLeftPageNumber));
        int crongRightMaxValue = Math.max(getSumMax(crongRightPageNumber),getMulMax(crongRightPageNumber));

        return answer;
    }

    public static boolean isOdd(int number) {
        if (number % 2 == 1) return true;
        return false;
    }

    public static boolean isContinuous(int leftPageNumber, int rightPageNumber) {
        if (rightPageNumber - leftPageNumber == 1) return true;
        return false;
    }

    public static Integer getSumMax(int number) {
        int maxValue = number % 10;
        number /= 10;
        while (number != 0) {
            maxValue += number % 10;
            number /= 10;
        }
        return maxValue;
    }

    public static Integer getMulMax(int number) {
        int maxValue = number % 10;
        number /= 10;
        while (number != 0) {
            maxValue += number % 10;
            number /= 10;
        }
        return maxValue;
    }


}