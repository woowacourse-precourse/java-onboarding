package onboarding;

import java.util.List;

class Problem1 {
    private static int addValue(int num){
        int answer = 0;
        answer += num % 10;
        while(num / 10 > 0){
            num = num / 10;
            answer += num % 10;
        }
        return answer;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //int pobiMax = addValue(pobi.get(0));
        //int crongMax = addValue(pobi.get(0));
        //System.out.println("pobi[max]"+pobi.get(0));
        //System.out.println("crong[max]"+crong.get(0)+"\n\n\n\n\n");
       //System.out.println("answer" + addValue(pobi.get(0)));
       //System.out.println("crong" + addValue(crong.get(0)));
        //return answer;

        return answer;
    }
}