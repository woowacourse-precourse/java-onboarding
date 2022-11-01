package onboarding;

import java.util.List;

class Problem1 {
    // 해당 숫자의 각 자리의 합을 구하기
    private static int getPlusNum(int n){
        int result = 0;
        while (n>0){
            result += n%10;

            n /= 10;
        }
        return result;
    }
    // 해당 숫자의 각 자리의 곱을 구하기
    private static int getMultiNum(int n){
        int result = 1;
        while (n>0){
            result *= n%10;

            n /= 10;
        }
        return result;
    }

    // 좌/우 숫자의 합/곱 중 가장 큰 수 찾기
    private static int getMaxNum(int a, int b, int c, int d){
        return Math.max(Math.max(a, b),Math.max(c, d));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);

        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        // 예외 상황 처리
        if (pobiLeft+1 != pobiRight || crongLeft+1 != crongRight || pobiRight%2 != 0 || crongRight%2 != 0 ){
            return -1;
        }

        int pobiPlus1 = getPlusNum(pobiLeft);
        int pobiMulti1 = getMultiNum(pobiLeft);
        int pobiPlus2 = getPlusNum(pobiRight);
        int pobiMulti2 = getMultiNum(pobiRight);

        int pobiNum = getMaxNum(pobiPlus1, pobiMulti1, pobiPlus2, pobiMulti2);

        int crongPlus1 = getPlusNum(crongLeft);
        int crongMulti1 = getMultiNum(crongLeft);
        int crongPlus2 = getPlusNum(crongRight);
        int crongMulti2 = getMultiNum(crongRight);

        int crongNum = getMaxNum(crongPlus1, crongMulti1, crongPlus2, crongMulti2);

        if (pobiNum>crongNum){
            // 포비가 이기는 경우
            answer = 1;
        } else if (pobiNum<crongNum) {
            // 크롱이 이기는 경우
            answer = 2;
        }
        // 무승부인 경우 (answer = 0)

        return answer;
    }
}