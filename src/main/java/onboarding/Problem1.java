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

    //양 페이지 비교(친구의 최종 점수)
    public static int pageCom(List<Integer> pageList){
        int temp, score = 0;
        for(int i = 0; i<2 ; i++){
            temp = pageMax(pageList.get(i));
            score = Math.max(score,temp);
        }
        return score;
    }

}

