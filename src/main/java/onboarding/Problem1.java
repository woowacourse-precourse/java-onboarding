package onboarding;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem1 {
    static int answer;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiNum = findMaxNum(pobi);
        int crongNum = findMaxNum(crong);

        if(pobiNum == crongNum){
            answer = 0;
        } else if( pobiNum > crongNum) {
            answer = 1;
        } else {
            answer = 2;
        }

        validatePage(pobi, crong);

        return answer;
    }

    public static Integer findMaxNum(List<Integer> pageList){
        int max = Integer.MAX_VALUE;
        PriorityQueue<Integer> candidate = new PriorityQueue<>(Comparator.reverseOrder());

        for(Integer page : pageList){
            String[] pageSplits = page.toString().split("");

            int plus = 0;
            int multi = 1;

            for(String pageString : pageSplits){
                int number = Integer.parseInt(pageString);
                plus += number;
                multi *= number;
            }
            candidate.add(plus);
            candidate.add(multi);

        }

        if(!candidate.isEmpty()){
            max = candidate.poll();
        }
        return max;
    }

    //예외사항
    public static void validatePage(List<Integer> pobi, List<Integer> crong){
        if(
                pobi.contains(1) || pobi.contains(400) || crong.contains(1) || crong.contains(400)
                || pobi.get(1)- pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1

        ){
            answer = -1;
        }

    }


}