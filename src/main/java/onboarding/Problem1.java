package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_score =0; int crong_score = 0;
        int temp;

        //예외처리
        if (pobi.get(0) +1 != pobi.get(1))  return -1;
        if (crong.get(0) +1 != crong.get(1))  return -1;

        for(int i = 0; i<2 ; i++){
            // 포비의 점수
            temp = pageMax(pobi.get(i));
            pobi_score = Math.max(pobi_score,temp);

            // 크롱의 점수
            temp = pageMax(crong.get(i));
            crong_score = Math.max(crong_score,temp);
        }

        if (pobi_score > crong_score)    return 1;
        else if (pobi_score < crong_score)  return 2;
        else    return 0;
    }

    // sum과 mul 중 큰 수를 구하는 함수
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

