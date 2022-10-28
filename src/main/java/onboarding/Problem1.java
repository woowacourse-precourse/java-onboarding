package onboarding;

import java.util.List;

/**
 * 요구 사항
 * 책을 임의로 펼친다.
 * 왼쪽 페이지는 짝수, 오른쪽 페이지는 홀수
 * 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
 * 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 * 비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때,
 * 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.
 */

/**
 * 설계
 * list 를 매개변수로 받아 가장 큰수를 return 하는 함수
 * pobi 점수와 crong 점수를 매개변수로 받아 비교하여 최종 return 값을 결정하는 함수
 */

/**
 * 예외사항(-1을 리턴)
 * 왼쪽 페이지가 홀수이거나 오른쪽 페이지가 짝수
 * 페이지가 1 ~ 400 이 아닐 때
 * 페이지가 연속된 수가 아닐 때 ex) 102 105
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE; // int 범위에서 최대값 2147483647

        int pobyScore = maxScore(pobi);
        int crongScore = maxScore(crong);

        answer = winResult(pobyScore, crongScore);

        return answer;
    }

    public static int maxScore(List<Integer> name) {  // 각 페이지의 최대값을 구해 각 페이지의 최대값을 비교하여 return
        int leftMaxScore = 0; // 왼쪽 페이지에서 가장 큰 값
        int rightMaxScore = 0; // 오른쪽 페이지에서 가장 큰 값

        for (int i=0; i<2; i++) {
            int pageNumber = name.get(i); // 0일 때 왼쪽, 1일 때 오른쪽
            int sum = 0; // 각 페이지의 자리수를 합한 결과
            int multi = 1; // 각 페이지의 자리수를 곱한 결과

            while (pageNumber > 0) {
                sum += pageNumber % 10; // 각 자리수를 더함
                multi *= pageNumber % 10; // 각 자리수를 곱함
                pageNumber /= 10;
            }

            if(sum > multi)  // 더한 값이 클 때
                leftMaxScore = sum;
            else   // 곱한 값이 클 때
                rightMaxScore = multi;
        }

        if (leftMaxScore > rightMaxScore) // 왼쪽 페이지가 클 떄
            return leftMaxScore;

        return rightMaxScore; // 오른쪽 페이지가 크거나 같을 때
    }

    public static int winResult(int poby, int crong) {
        if(poby > crong) // poby 가 승리
            return 1;
        else if (crong < poby) // crong 이 승리
            return 2;

        return 0;
    }

}