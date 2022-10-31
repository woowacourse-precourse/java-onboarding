package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi.get(0), pobi.get(1)) || isException(crong.get(0), crong.get(1))) return -1;

        // 양쪽 페이지 중 더 큰 수를 본인의 점수로 저장
        int pobiMax = Math.max(getCalMax(pobi.get(0)), getCalMax(pobi.get(1)));
        int crongMax = Math.max(getCalMax(crong.get(0)), getCalMax(crong.get(1)));

        return getResult(pobiMax, crongMax);
    }

    public static boolean isException(int leftPage, int rightPage) {
        //페이지가 연속된 페이지가 아닌 경우 예외 처리
        if (Math.abs(leftPage - rightPage) > 1) return true;
        // 시작 면이나 마지막 면을 펼쳤을 경우 (1~2페이지, 399~400페이지) 예외 처리
        if (leftPage == 1 || rightPage == 400) return true;
        // 왼쪽이 짝수거나 오른쪽이 홀수인 경우 예외 처리
        if (leftPage % 2 == 0 || rightPage % 2 != 0) return true;
        // 양쪽 페이지가 같거나 왼쪽 페이지가 오른쪽 페이지보다 클 경우 예외 처리
        return leftPage >= rightPage;
    }

    public static int getCalMax(int page) {
        int sum = 0;
        int muti = 1;

        while (page > 0) {
            sum += (page % 10);
            muti *= (page % 10);
            page /= 10;
        }

        return Math.max(sum, muti);
    }

    public static int getResult(int pobiMax, int crongMax) {
        if (pobiMax > crongMax) return 1;
        else if (pobiMax < crongMax) return 2;
        return 0;
    }
}