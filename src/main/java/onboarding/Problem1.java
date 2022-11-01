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

    private static boolean isException(List<Integer> person) {
        // 주어진 페이지가 책 페이지 내의 페이지 수여야 함
        if(1 <= person.get(0) && person.get(1) <= 400) {
            return false;
        }

        // 왼쪽페이지가 홀수, 오른쪽페이지가 짝수여야 함
        if(person.get(0)%2 == 1 && person.get(1)%2 == 0) {
            return false;
        }

        // 두 페이지가 연속되어야 함
        if(person.get(1) - person.get(0) == 1){
            return false;
        }

        return true;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외사항 체크
        if(isException(pobi) || isException(crong)) {
            return -1;
        }

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