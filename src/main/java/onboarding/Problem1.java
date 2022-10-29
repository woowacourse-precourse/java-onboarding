package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.get(0) + 1 != pobi.get(1)) || crong.get(0) + 1 != crong.get(1)) {
            return -1;
        }
        int pobiMaxValue = chooseBigOneInPerson(pobi);

        int crongMaxValue = chooseBigOneInPerson(crong);

        int answer;
        if (pobiMaxValue > crongMaxValue)
            answer = 1;
        else if (pobiMaxValue < crongMaxValue)
            answer = 2;
        else
            answer = 0;
        return answer;
    }

    /**
     * 사람이 뽑은 책 페이지의 배열을 넣으면 규칙에 맞게 계산하여 그 중 큰 값을 리턴한다.
     * @param person
     * @return
     */
    public static int chooseBigOneInPerson(List<Integer> pages) {
        int BigValueInLeftPage = chooseBigOneInBook(separateNum(pages.get(0)));
        int BigValueInRightPage = chooseBigOneInBook(separateNum(pages.get(1)));
        return BigValueInLeftPage > BigValueInRightPage ? BigValueInLeftPage : BigValueInRightPage;
    }

    /**
     * 배열을 받아 각 자리의 수를 더하거나, 모두 곱한 것중 가장 큰 수를 구한다.
     *
     * @param num
     * @return
     */
    public static int chooseBigOneInBook(int[] num) {
        int totalAdd = 0, totalMulti = 1;
        for (int i = 0; i < num.length; i++) {
            totalAdd += num[i];
            totalMulti *= num[i];
        }
        return totalAdd > totalMulti ? totalAdd : totalMulti;
    }

    /**
     * 받아온 숫자를 배열로 리턴해준다.
     *
     * @param num
     * @return
     */
    public static int[] separateNum(int num) {
        String strNum = Integer.toString(num);
        int[] arrNum = new int[strNum.length()];
        for (int i = 0; i < strNum.length(); i++) {
            arrNum[i] = strNum.charAt(i) - '0';
        }
        return arrNum;
    }
}