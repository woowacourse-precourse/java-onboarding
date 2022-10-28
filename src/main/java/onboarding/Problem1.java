package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 책을 임의로 펼친다.
 * 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
 * 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 *
 * 포비가 이기면1, 크롱이 이기면 2, 무승부 0, 예외사항 -1
 *
 * TESTCASE
 * pobi   /   crong   / result
 * [97, 98] / [197,198] / 0
 * [131, 132] / [211, 212] / 1
 * [99, 102]  / [211, 212] / -1
 */

/**TODO
 * 각 자리 합을 더하는 메서드
 * 각 자리를 모두 곱하는 메서드
 * 합과 곱 중 가장 큰 값을 리턴
 * 예외 처리
 * * 페이지가 1보다 작거나 400보다 큰 경우
 * * 왼쪽과 오른쪽 페이지의 번호의 차가 1인경우
 * *
 */

class Problem1 {

    public static void main(String[] args) {
        ArrayList<Integer> pobi = new ArrayList<>();
        ArrayList<Integer> crong = new ArrayList<>();

        pobi.add(4);
        pobi.add(5);

        crong.add(397);
        crong.add(398);

        System.out.println(solution(pobi, crong));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiMaxNum;
        int crongMaxNum;

        if (!validation(pobi) || !validation(crong))
            return -1;

        pobiMaxNum = Math.max(addCalc(pobi.get(0)), addCalc(pobi.get(1)));
        pobiMaxNum = Math.max(pobiMaxNum, mulCalc(pobi.get(0)));
        pobiMaxNum = Math.max(pobiMaxNum, mulCalc(pobi.get(1)));

        crongMaxNum = Math.max(addCalc(crong.get(0)), addCalc(crong.get(1)));
        crongMaxNum = Math.max(crongMaxNum, mulCalc(crong.get(0)));
        crongMaxNum = Math.max(crongMaxNum, mulCalc(crong.get(1)));

        if (pobiMaxNum == crongMaxNum)
            return 0;
        if (pobiMaxNum > crongMaxNum)
            return 1;
        else
            return 2;
    }

    public static int addCalc(int num) {
        
        String numToString = String.valueOf(num);
        int result = 0;
        for (int i = 0; i < numToString.length(); i++) {
            char c = numToString.charAt(i);
            result += Integer.valueOf(c) - '0';
        }
        return result;
    }

    public static int mulCalc(int num) {

        String numToString = String.valueOf(num);
        int result = 1;
        for (int i = 0; i < numToString.length(); i++) {
            char c = numToString.charAt(i);
            result *= Integer.valueOf(c) - '0';
        }
        return result;
    }

    static boolean validation(List<Integer> list) {

        int firstPage =list.get(0);
        int secondPage = list.get(1);

        if(firstPage < 3 || firstPage > 398 || secondPage < 3 || secondPage > 398 )
            return false;
        if(firstPage % 2 != 1 || secondPage % 2 !=0)
            return false;
        if (firstPage - secondPage != -1)
            return false;
        return true;

    }
}