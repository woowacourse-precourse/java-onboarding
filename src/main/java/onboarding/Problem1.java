package onboarding;

import java.util.List;

class Problem1 {
    private static int sum(Integer num) {
        int ans = 0;
        while(num > 0) {
            ans += (num%10);
            num /= 10;
        }
        return ans;
    }

    private static int multiple(Integer num) {
        int ans = 1;
        while(num > 0) {
            ans *= (num%10);
            num /= 10;
        }
        return ans;
    }

    private static boolean checkPage(List<Integer> pageList) {
        if(pageList.get(0) + 1 == pageList.get(1))
            return true;
        else
            return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            if(!checkPage(pobi))
                return -1;
            if(!checkPage(crong))
                return -1;

            int answer = Integer.MAX_VALUE;
            return answer;
        } catch (Exception e) {
            return -1;
        }
    }
}