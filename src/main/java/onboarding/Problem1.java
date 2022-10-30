package onboarding;

import java.util.List;

/* TODO
* 1. 입력이 올바른지 체크
* 2. 각 자리 숫자 더하기
* 3. 각 자리 숫자 곱하기
* 4. 본인의 가장 큰 수 구하기
* 3. 게임의 승자 가리기
* */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkInput(pobi, crong) != 1)
            return -1;
        return 1;
    }

    private static int checkInput(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (pobiLeft<=1 || pobiRight >=400 || crongLeft<=1 || crongRight >=400)
            return -1;
        if (pobiLeft%2 == 0 || pobiRight%2 ==1 || crongLeft%2 == 0 || crongRight%2 ==1)
            return -1;
        if (pobiRight-pobiLeft != 1 || crongRight-crongLeft != 1)
            return -1;
        return 1;
    }
}