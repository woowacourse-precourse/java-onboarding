package onboarding;

import java.util.List;

class Problem1 {
    static int max(int num1, int num2, int num3, int num4) {// 4개 숫자 중 가장 큰 수 반환
        int max = num1;
        if(num2 > max) max = num2;
        if(num3 > max) max = num3;
        if(num4 > max) max = num4;
        return max;
    }

    static int addAndMulti(int n1, int n2) { // 점수 구하기
        int maxNum = 0;
        int resultAdd1 = 0, resultAdd2 =0;
        int resultMulti1 = 0 , resultMulti2 = 0;

        while(n1 > 0 && n2 > 0){

            resultAdd1 += n1 %10;
            resultMulti1 *= n1%10;
            resultAdd2 += n2%10;
            resultMulti2 *= n2%10;

            n1 /= 10;
            n2 /= 10;
        }
        maxNum = max(resultAdd1, resultAdd2, resultMulti1, resultMulti2);

        return maxNum;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = 0, crongScore = 0;
        // list 값 받아오기
        int pobiNum1 = pobi.get(0);
        int pobiNum2 = pobi.get(1);
        int crongNum1 = crong.get(0);
        int crongNum2 = crong.get(1);

        // 점수 받아오기
        pobiScore = addAndMulti(pobiNum1, pobiNum2);
        crongScore = addAndMulti(crongNum1, crongNum2);

        // -1 return 하는 경우
        // 왼쪽 페이지가 홀수인지 확인
        if (pobiNum1 % 2 == 0 || crongNum1%2 ==0 )  answer =  -1;
        // 책 페이지가 연속된 숫자인지 확인
        if (pobiNum1+1 != pobiNum2 || crongNum1+1 != crongNum2 ) answer =  -1;
        // 첫번째 페이지 범위 확인
        if ((pobiNum1<1 && pobiNum1>400) || (crongNum1<1 && crongNum1>400)) answer =  -1;
        // 두번째 페이지 범위 확인
        if ((pobiNum2<1 && pobiNum2>400) || (crongNum2<1 && crongNum2>400)) answer =  -1;

        if (answer != -1) {
            //포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0
            if (pobiScore > crongScore) answer = 1;
            if (pobiScore == crongScore) answer = 0;
            if (pobiScore < crongScore) answer = 2;
        }
        return answer;
    }


}