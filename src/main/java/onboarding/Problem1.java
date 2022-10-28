package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //int answer = Integer.MAX_VALUE;
        if(pobi.size() !=2 || crong.size() !=2) return -1;
        if(pobi.get(0) != pobi.get(1)-1 || crong.get(0) != crong.get(1)-1) return -1;

        if(score(pobi)>score(crong)){
            return 1;
        } else if (score(pobi)<score(crong)) {
            return 2;
        } else if (score(pobi) == score(crong)) {
            return 0;
        }

        return -1;
    }

    public static int score(List<Integer> pages){
        int max_score = 0;
        int page_num;
        int sum;
        int mul;

        for(int i =0; i < 2; i++){
            page_num = pages.get(i);
            sum = 0;
            mul = 1;
            while(page_num>0){
                sum += page_num%10;
                mul *= page_num%10;
                page_num /= 10;
            }
            if(sum < mul){
                if(max_score< mul){
                    max_score = mul;
                }
            } else {
                if(max_score<sum){
                    max_score = sum;
                }
            }
        }
        return max_score;
    }
}