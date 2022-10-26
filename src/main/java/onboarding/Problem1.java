package onboarding;

import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMax;
        int crongMax;

        pobiMax = (getPlus(pobi) > getMul(pobi)) ? getPlus(pobi) : getMul(pobi);
        crongMax = (getPlus(crong) > getMul(crong) ? getPlus(crong) : getMul(crong));

        answer = getMax(pobiMax, crongMax);

        if((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1))
            answer = -1;

        return answer;
    }

    static int getPlus(List<Integer> list) {
        int listPlusLeft, listPlusRight;

        if (list.get(0)/10 == 0) {
            return list.get(1);
        } else if (list.get(0)/100 == 0) {
            listPlusLeft = (list.get(0) % 10) + (list.get(0) / 10);
            listPlusRight = (list.get(1) % 10) + (list.get(1) / 10);
        } else {
            listPlusLeft = (list.get(0) / 100) + ((list.get(0) % 100) / 10) + (list.get(0) % 10);
            listPlusRight = (list.get(1) / 100) + ((list.get(1) % 100) / 10) + (list.get(1) % 10);
        }

        return listPlusLeft > listPlusRight ? listPlusLeft : listPlusRight;
    }
    static int getMul(List<Integer> list) {
        int listMulLeft, listMulRight;

        if (list.get(0)/10 == 0) {
            return list.get(1);
        } else if (list.get(0)/100 == 0) {
            listMulLeft = (list.get(0) % 10) * (list.get(0) / 10);
            listMulRight = (list.get(1) % 10) * (list.get(1) / 10);
        } else {
            listMulLeft = (list.get(0) / 100) * ((list.get(0) % 100) / 10) * (list.get(0) % 10);
            listMulRight = (list.get(1) / 100) * ((list.get(1) % 100) / 10) * (list.get(1) % 10);
        }

        return listMulLeft > listMulRight ? listMulLeft : listMulRight;
    }

    static int getMax(int pobi, int crong) {
        return (pobi == crong) ? 0 : (pobi > crong) ? 1 : 2;
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
     * 기존의 코드에 중복되는 부분이 너무 많아서 각 메소드를 생성하여 나누어 주었다.
     */
}