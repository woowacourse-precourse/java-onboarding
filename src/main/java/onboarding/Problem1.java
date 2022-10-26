package onboarding;

import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMax, pobiPlusLeft, pobiMulLeft, pobiPlusRight, pobiMulRight;
        int crongMax, crongPlusLeft, crongMulLeft, crongPlusRight, crongMulRight;

        if (pobi.get(0)/10 == 0) {
            pobiMax = pobi.get(1);
        } else if (pobi.get(0)/100 == 0) {
            pobiPlusLeft = (pobi.get(0) % 10) + (pobi.get(0) / 10);
            pobiMulLeft = (pobi.get(0) % 10) * (pobi.get(0) / 10);

            pobiPlusRight = (pobi.get(1) % 10) + (pobi.get(1) / 10);
            pobiMulRight = (pobi.get(1) % 10) * (pobi.get(1) / 10);

            pobiMax = ((pobiPlusLeft > pobiMulLeft) ? pobiPlusLeft : pobiMulLeft) > ((pobiPlusRight > pobiMulRight) ? pobiPlusRight : pobiMulRight) ?
                    ((pobiPlusLeft > pobiMulLeft) ? pobiPlusLeft : pobiMulLeft) : ((pobiPlusRight > pobiMulRight) ? pobiPlusRight : pobiMulRight);
        } else {
            pobiPlusLeft = (pobi.get(0) / 100) + ((pobi.get(0) % 100) / 10) + (pobi.get(0) % 10);
            pobiMulLeft = (pobi.get(0) / 100) * ((pobi.get(0) % 100) / 10) * (pobi.get(0) % 10);

            pobiPlusRight = (pobi.get(1) / 100) + ((pobi.get(1) % 100) / 10) + (pobi.get(1) % 10);
            pobiMulRight = (pobi.get(1) / 100) * ((pobi.get(1) % 100) / 10) * (pobi.get(1) % 10);

            pobiMax = ((pobiPlusLeft > pobiMulLeft) ? pobiPlusLeft : pobiMulLeft) > ((pobiPlusRight > pobiMulRight) ? pobiPlusRight : pobiMulRight) ?
                    ((pobiPlusLeft > pobiMulLeft) ? pobiPlusLeft : pobiMulLeft) : ((pobiPlusRight > pobiMulRight) ? pobiPlusRight : pobiMulRight);
        }

        if (crong.get(0)/10 == 0) {
            crongMax = crong.get(1);
        } else if (crong.get(0)/100 == 0) {
            crongPlusLeft = (crong.get(0) % 10) + (crong.get(0) / 10);
            crongMulLeft = (crong.get(0) % 10) * (crong.get(0) / 10);

            crongPlusRight = (crong.get(1) % 10) + (crong.get(1) / 10);
            crongMulRight = (crong.get(1) % 10) * (crong.get(1) / 10);

            crongMax = ((crongPlusLeft > crongMulLeft) ? crongPlusLeft : crongMulLeft) > ((crongPlusRight > crongMulRight) ? crongPlusRight : crongMulRight) ?
                    ((crongPlusLeft > crongMulLeft) ? crongPlusLeft : crongMulLeft) : ((crongPlusRight > crongMulRight) ? crongPlusRight : crongMulRight);
        } else {
            crongPlusLeft = (crong.get(0) / 100) + ((crong.get(0) % 100) / 10) + (crong.get(0) % 10);
            crongMulLeft = (crong.get(0) / 100) * ((crong.get(0) % 100) / 10) * (crong.get(0) % 10);

            crongPlusRight = (crong.get(1) / 100) + ((crong.get(1) % 100) / 10) + (crong.get(1) % 10);
            crongMulRight = (crong.get(1) / 100) * ((crong.get(1) % 100) / 10) * (crong.get(1) % 10);

            crongMax = ((crongPlusLeft > crongMulLeft) ? crongPlusLeft : crongMulLeft) > ((crongPlusRight > crongMulRight) ? crongPlusRight : crongMulRight) ?
                    ((crongPlusLeft > crongMulLeft) ? crongPlusLeft : crongMulLeft) : ((crongPlusRight > crongMulRight) ? crongPlusRight : crongMulRight);
        }

        answer = (crongMax == pobiMax) ? 0 : ((crongMax > pobiMax) ? 2 : 1);

        if((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1))
            answer = -1;

        return answer;
    }
    /**
     * 왼쪽 페이지의 번호 각자리를 더하거나 곱해서 가장 큰 수
     * 오른쪽 마찬가지
     * 그 중에 큰 수를 본인의 점수로
     * 포비 vs 크롱 큰 숫자가 이김
     * pobi와 crong 이라는 리스트 에는 각 페이지가 들어 있다.
     * 포비 승 : 1 크롱 승 : 2 무승부 : 0 예외사항 : -1 -> answer 값
     */

    /**
     * 한자리일 경우
     * 두자리일 경우
     * 세자리일 경우
     * 각각을 생각해야...
     */

    /**
     * 2, 1, 0 의 경우를 각각의 if문을 사용하게 되면 너무 많은 공간을 차지할 듯 하여
     * 중첩 3항 연산자를 사용함
     * 그리고 -1이 나오게 될 예외의 경우는 if를 사용하게 되었다.
     */

    /**
     * 기존에 pobiLeft, pobiRight, crongRight, crongLeft 와 같이 각 왼쪽 페이지 오른쪽 페이지의
     * 큰값을 저장하도록 하였으나 삭제하여 더 짧은 코드를 만들 수 있을 것이라 생각하여 지움
     * 하지만 이것이 성능에 크게 영향은 없는 듯 하고 코드 가독성이 오히려 떨어지는 느낌이 들어
     * 어떤 선택이 좋은 선택일지 고민 해봐야 할 듯 하다
     */
}