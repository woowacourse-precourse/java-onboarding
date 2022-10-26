package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int[] pobiSumMulti = new int[] {0, 1};
        int[] crongSumMulti = new int[] {0, 1};

        if (pobi.get(0) != 1 && pobi.get(0) != 399 && pobi.get(0) % 2 == 1 && ((pobi.get(0)+1) == pobi.get(1))
            && (crong.get(0) != 1 && crong.get(0) != 399 && crong.get(0) % 2 == 1 && ((crong.get(0)+1) == crong.get(1)))
        ) {
            String[] pobiRightArr = pobi.get(1).toString().split("");
            String[] crongRightArr = crong.get(1).toString().split("");

            for (int i = 0; i < pobiRightArr.length; i++) {
                pobiSumMulti[0] += Integer.parseInt(pobiRightArr[i]);
                pobiSumMulti[1] *= Integer.parseInt(pobiRightArr[i]);
            }

            for (int i = 0; i < crongRightArr.length; i++) {
                crongSumMulti[0] += Integer.parseInt(crongRightArr[i]);
                crongSumMulti[1] *= Integer.parseInt(crongRightArr[i]);
            }

            Arrays.sort(pobiSumMulti);
            Arrays.sort(crongSumMulti);

            if (pobiSumMulti[1] > crongSumMulti[1]) {
                answer = 1;
            } else if (pobiSumMulti[1] < crongSumMulti[1]) {
                answer = 2;
            } else {
                answer = 0;
            }

        } else {
            answer = -1;
        }

        return answer;
    }
}


// pobi	        crong	    result
// [97, 98]	    [197, 198]	0
// [131, 132]	[211, 212]	1
// [99, 102]	[211, 212]	-1

// 조건을 만족하는 지 점검
// 각 입력값을 더하거나 곱한 값을 배열로 생성한 후 정렬
// 가장 큰 값을 비교하여 result 출력
