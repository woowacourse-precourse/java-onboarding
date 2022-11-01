package onboarding;

import java.util.ArrayList;
import java.util.List;

//      규칙
//        	1. 책을 임의로 펼친다.
//                1-1) 매개변수를 받는다.
//                1-2) ApplicationTest case 1,2,3 에 상수 기입되어있음
//          >>입력에대한 구현 불필요, 걍 무시하자.
//      ------------------------------------------------------------
//        	2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
//                2-1) 12페이지면 1, 2를 더하거나 곱해서 비교하여 큰수를 반환한다?
//        	3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
//                3-1) 오른쪽 페이지도 2-1과 동일한 결과 반환
//        >> 2,3 동일한 메서드 사용가능.
//        >> getAddNumber : 각 자리 숫자 더한값 반환 메서드
//        >> getMulNumber : 각 자리 숫자 곱한값 반환 메서드
//        >> getHighestValue : 더한값, 곱한값 중 가장 큰수 반환 메서드
//              >> 메서드 통합.
//      ------------------------------------------------------------
//        	4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
//                4-1) 왼쪽, 오른쪽 페이지 2,3 연산 후 비교
//                4-2) 비교값 둘중에 큰 수를 pobi, crong 각각 가진다.
//        	5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
//                5-1) pobi, crong 최종 큰수 비교
//                5-2) 더 큰수 가진자 승리
//                5-3) 포비 승리 1, 크롱 승리 2, 무승부 0, 예외사항 -1
//        	6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
//                6-1) 1또는 400의 수는 예외사항으로 처리.
//      포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때, 포비가 이긴다면 1, 크롱이 이긴다면 2,
//      무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.
//
//      제한사항 (예외사항)
//	        • pobi와 crong의 길이는 2이다.
//              - List 길이가 2
//	        • pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.
//              - 12 이면 13, 연번의 개념인듯.
//          • 1~400 페이지
//          • 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수
//           6-1) 1또는 400의 수는 예외사항으로 처리.

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (isException(pobi) || isException(crong)) {  // 예외상황시 비교연산 비실행 -1 반환
            answer = -1;
        }
        else {          // 예외 체크후 비교연산 시작
            int pobiScore = getHighestValue(pobi);
            int crongScore = getHighestValue(crong);
//          pobi, crong 최종스코어 비교
            if (pobiScore == crongScore) {
                answer = 0;
            }
            else if (pobiScore > crongScore) {
                answer = 1;
            }
            else if (pobiScore < crongScore) {
                answer = 2;
            }
        }
        return answer;
    }

    private static int getAddNumber(int page) {
        int addResult = 0; // 자릿수별 초기 값

//      왼쪽, 오른쪽 페이지 수 한자리 수로 구분.
        String strNum = Integer.toString(page);
        int[] arrNum = new int[strNum.length()];
        for (int i = 0; i < strNum.length(); i++) {
            arrNum[i] = strNum.charAt(i) - '0';
            addResult += arrNum[i];
        }
        return addResult;
    }

    private static int getMulNumber(int page) {
        int mulResult = 1; // 자릿수별 초기 값

//      왼쪽, 오른쪽 페이지 수 한자리 수로 구분.
        String strNum = Integer.toString(page);
        int[] arrNum = new int[strNum.length()];
        for (int i = 0; i < strNum.length(); i++) {
            arrNum[i] = strNum.charAt(i) - '0';
            mulResult *= arrNum[i];
        }
        return mulResult;
    }

    private static int getHighestValue(List<Integer> player) {
        int calResult = 0;
        int addLeftPage = getAddNumber(player.get(0));
        int addRightPage = getAddNumber(player.get(1));
        int mulLeftPage = getMulNumber(player.get(0));
        int mulRightPage = getMulNumber(player.get(1));
        int leftResult = getComparisonValue(addLeftPage, mulLeftPage);
        int rightResult = getComparisonValue(addRightPage, mulRightPage);
//      pobi, crong 최종 스코어 비교
        if (leftResult >= rightResult) {
            calResult = leftResult;
        } else if (leftResult < rightResult) {
            calResult = rightResult;
        }
        return calResult;
    }

    private static int getComparisonValue(int addPage, int mulPage) {
        int calResult = 0;
        if (addPage >= mulPage) {
            calResult = addPage;
        } else if (addPage < mulPage) {
            calResult = mulPage;
        }
        return calResult;
    }

    private static boolean isException(List<Integer> page) {
        boolean isException = false;
        if (page.get(0) <= 1 || page.get(0) >= 400 || page.get(1) <= 1 || page.get(1) >= 400) { // 페이지가 2~399 페이지 사이가 아니라면
            isException = true; //예외처리
        }

        // left가 홀수인가, right가 짝수인가
        else if (page.get(0) % 2 != 1 || page.get(1) % 2 != 0) {
            isException = false; //예외처리
        }
        // left와 right가 연번인가
        else if (page.get(1) - page.get(0) != 1) {
            isException = true; //예외처리
        }
        return isException;
    }
}

