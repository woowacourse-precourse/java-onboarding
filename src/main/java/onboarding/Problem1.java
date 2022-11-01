package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validPages(pobi) || !validPages(crong))
            return -1;

        int pobi_score = pageCom(pobi);
        int crong_score = pageCom(crong);

        //최종 결과 출력
        if (pobi_score > crong_score)    return 1;
        else if (pobi_score < crong_score)  return 2;
        else    return 0;
    }

    // 예외처리
    public static boolean validPages(List<Integer> pageList){
        //유효한 페이지
        if (pageList.get(0) +1 != pageList.get(1))
            return false;
        //2~399 (처음과 마지막을 제외한 유효한 책 범위)
        for(int i=0; i<2; i++){
            if(pageList.get(i) <= 1 || pageList.get(i) >= 400)
                return false;
        }
        return true;
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

