package onboarding;

import java.util.List;

class Problem1 {
    private static int findMax(List<Integer> person) {
        int max = -1;

        for (int i = 0; i < person.size(); i++) {
            int sum = 0;
            int multiple = 1;
            int page = person.get(i);
            while(page > 0) {
                sum += page%10;
                page = page/10;
            }
            page = person.get(i);
            while(page > 0) {
                multiple *= page%10;
                page = page/10;
            }
            max = Math.max(max, Math.max(sum, multiple));
        }
        return max;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMax = findMax(pobi);
        int crongMax = findMax(crong);

        System.out.println(pobiMax);
        System.out.println(crongMax);
        if(pobiMax > crongMax) {
            answer = 1;
        }else if(pobiMax < crongMax) {
            answer = 2;
        }else {
            answer = 0;
        }

        return answer;
    }

}