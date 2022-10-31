package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return 0;
    }

    // 페이지의 각 자리 수의 합과 곱 중 큰 수를 구하는 기능
    public static int pageMax(int pageInt){
        String page = Integer.toString(pageInt);
        int sum = 0; int mul = 1, n;

        for(int j=0; j<page.length(); j++){
            n = page.charAt(j) - '0';
            sum +=n;
            mul *=n;
        }
        return Math.max(sum,mul);
    }


}

