package onboarding;

import java.util.List;

class Problem1 {
    public static int maxResult (List<Integer> pages) {
        //각 페이지 번호의 각 자리 숫자를 모두 더하거나 곱해서 가장 큰 수를 구함
        int sum = 0;
        int multiple = 1;
        int max = Integer.MIN_VALUE;


        if(pages.get(1) - pages.get(0) != 1) return -1;

        for (int i=0; i<pages.size(); i++) {
            int temp = pages.get(i);

            if (temp <= 2 || temp >= 399) return -1;

            while (temp != 0) {
                sum += temp % 10;
                multiple *= temp % 10;

                temp /= 10;
            }

            if (sum > multiple) {
                if (max < sum) max = sum;
            } else if (max < multiple) max = multiple;

            sum = 0;
            multiple = 1;
        }

        return max;
    }

    public static int solution (List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = maxResult (pobi);
        int crongScore = maxResult (crong);

        if (pobiScore > crongScore) answer = 1;
        else if (pobiScore == -1 || crongScore == -1) answer = -1;
        else if(pobiScore == crongScore) answer = 0;
        else answer = 2;

        return answer;
    }
}