package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        Problem1 mission = new Problem1();

        // 페이지 값이 정상인지 확인
        boolean pageTrueOrFalse = mission.checkPageIndex(pobi.get(0), pobi.get(1)) && mission.checkPageIndex(crong.get(0), crong.get(1));

        if (!(pageTrueOrFalse)) { // 페이지 값이 비정상이면
            answer = -1;

        } else { // 페이지 값이 정상이면
            int pobiLargeFristNum = mission.getLargeNum(pobi.get(0)); // 포비의 왼쪽 페이지의 계산 값 중 큰 값
            int pobiLargeSecondNum = mission.getLargeNum(pobi.get(1)); // 포비의 오른쪽 페이지의 계산 값 중 큰 값

            int crongLargeFristNum = mission.getLargeNum(crong.get(0)); // 크롱의 왼쪽 페이지의 계산 값 중 큰 값
            int crongLargeSecondNum = mission.getLargeNum(crong.get(1)); // 크롱의 오른쪽 페이지의 계산 값 중 큰 값

            int pobiLargeNum = mission.getLargeNum(pobiLargeFristNum, pobiLargeSecondNum); // 포비의 왼쪽 값과 오른쪽 값 중 큰 값을 저장
            int crongLargeNum = mission.getLargeNum(crongLargeFristNum, crongLargeSecondNum); // 크롱의 왼쪽 값과 오른쪽 값 중 큰 값을 저장

            answer = mission.battle(pobiLargeNum, crongLargeNum); // 포비와 크롱의 결투
        }
        return answer;
    }

    // 첫페이지와 두번째 페이지가 정상 값인지 확인한다.
    public boolean checkPageIndex(Integer firstPage, Integer secondPage) {
        // 첫 페이지가 홀수가 아니거나 두번째 페이지가 짝수가 아니면 return false
        if (firstPage % 2 != 1 && secondPage % 2 != 0) {
            return false;
        }
        // 첫페이지와 두번째페이지의 차가 1 of -1 이 아닐 경우 return false
        if (!((firstPage - secondPage) == -1)) {
            return false;
        }

        // 첫페이지가 1보다 크거나 같지 않고 두번째 페이지가 400보다 작거나 같지 않으면 return false
        if (!(firstPage >= 1 || firstPage <= 399 || secondPage >= 2 || secondPage <= 400)) {
            return false;
        }

        // 위 경우를 통과하면 정상으로 판별
        return true;
    }

    // #오버로딩. 정수를 넘기면 각 자리 숫자를 더하거나 곱하여 큰 값을 return
    public int getLargeNum(Integer value) {
        int largeNum = 0; // return 할 가장 큰 값
        int subNum = 0; // 합 값
        int multiNum = 1; // 곱 값 (곱 연산을 위해 초기 값을 1로 지정)


        int numLen = Integer.toString(value).length();
        int[] arr = new int[numLen];

        for (int i = 0; i < numLen; i++) { // 각 자릿 수를 구하기
            arr[i] = value % 10;
            value /= 10;
        }

        for (int arrValue : arr) { // 합, 곱 값 구하기
            subNum += arrValue;
            multiNum *= arrValue;
        }

        if (subNum >= multiNum) {
            largeNum = subNum;
        } else {
            largeNum = multiNum;
        }

        return largeNum;
    }

    // #오버로딩. 2개의 정수 값을 받으면 큰 값을 return
    public int getLargeNum(Integer firstValue, Integer secondValue) {
        int largeNum = firstValue; // return 할 큰 값 (기본 값으로 첫번째 값을 가장 큰 값으로 설정한다.)

        if (secondValue > firstValue) { // second 값이 클 경우 largeNum 변경
            largeNum = secondValue;
        }

        return largeNum;
    }

    public int battle(Integer pobiNum, Integer crongNum) {
        if (pobiNum > crongNum) { // 포비가 이긴 경우 return 1
            return 1;
        } else if (pobiNum < crongNum) { // 크롱이 이긴 경우 return 2
            return 2;
        } else if (pobiNum == crongNum) { // 무승부인 경우 return 0
            return 0;
        } else { // 혹시 모를 경우를 대비하여 모든 값이 아닌 경우 return -1
            return -1;
        }
    }
}