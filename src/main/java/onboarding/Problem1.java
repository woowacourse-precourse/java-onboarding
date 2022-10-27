package onboarding;

import java.util.List;

class Problem1 {
    /**
     - 수행 :
     1) 왼쪽 페이지의 각 숫자를 더하거나 곱함
     2) 오른쪽 페이지의 각 숫자를 더하거나 곱함
     3) 그 중 큰 수를 자신의 숫자로 정함
     4) 이걸 비교해서 승부를 가림

     - 제한 조건:
     1) 페이지 수는 1~400
     2) 왼쪽 - 홀수, 오른쪽 - 짝수
     3) 시작면, 마지막면은 나오지 않도록 한다.

     - 입력:
     포비/크롱 리스트에 각각의 펼친 페이지가 들어 있음
     ( 왼쪽페이지, 오른쪽페이지 2 크기의 리스트 )

     - 출력:
     포비가 이기면 1, 크롱이 이기면 2, 무승부는 0, 예외사항은 -1

     **/
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiResult = 0;
        int crongResult = 0;
        int pobiSum = 0;
        int pobiMul = 1;
        int crongSum = 0;
        int crongMul = 1;

        for (int i = 0; i < 2; i++) {
            if(pobi.get(i) <= 1 || pobi.get(i) >= 400) return -1;
            if(crong.get(i) <= 1 || crong.get(i) >= 400) return -1;

            String pobiString = pobi.get(i).toString();
            String crongString = crong.get(i).toString();

            for (int j = 0; j < pobiString.length(); j++) {
                pobiSum += Character.getNumericValue(pobiString.charAt(j));
                pobiMul *= Character.getNumericValue(pobiString.charAt(j));
            }

            for (int j = 0; j < crongString.length(); j++) {
                crongSum += Character.getNumericValue(crongString.charAt(j));
                crongMul *= Character.getNumericValue(crongString.charAt(j));
            }

            if(pobiSum < pobiMul) {
                if (pobiResult < pobiMul) {
                    pobiResult = pobiMul;
                }
            }
            else {
                if (pobiResult < pobiSum) {
                    pobiResult = pobiSum;
                }
            }

            if(crongSum < crongMul) {
                if (crongResult < crongMul) {
                    crongResult = crongMul;
                }
            }
            else {
                if (crongResult < crongSum) {
                    crongResult = crongSum;
                }
            }
        }

        if(crongResult < pobiResult) answer = 1;
        else if(crongResult > pobiResult) answer = 2;
        else if(crongResult == pobiResult) answer = 0;
        else return -1;

        return answer;
    }
}