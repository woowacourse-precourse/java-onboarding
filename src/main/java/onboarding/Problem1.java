package onboarding;

import java.util.List;

class Problem1 {
    static int pobiNum;

    static int crongNum;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        pobiNum = findMaxNum(pobi);
        crongNum = findMaxNum(crong);

        if(pobiNum == crongNum){
            answer = 0;
        } else if( pobiNum > crongNum) {
            answer = 1;
        } else {
            answer = -1;
        }


        return answer;
    }

    public static Integer findMaxNum(List<Integer> eachList){
        int max = Integer.MAX_VALUE;

        for(Integer page : eachList){
            String[] pageSplits = page.toString().split("");

            int plus = 0;
            int multi = 1;

            for(String pageString : pageSplits){
                int number = Integer.parseInt(pageString);
                plus += number;
                multi *= number;

                if(plus >= multi){
                    max = plus;
                }
            }
        }
        return max;
    }

}