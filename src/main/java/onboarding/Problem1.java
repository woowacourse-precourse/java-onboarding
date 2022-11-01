package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMax = start(pobi);
        int crongMax = start(crong);
        int answer=0;
        if(pobiMax>-1 && crongMax>-1) {
            answer = winner(pobiMax, crongMax);
        }else answer=-1;

        return answer;
    }

    public static int start(List<Integer> pageList){
        int max=0;
        int i=0;
        for(int page=pageList.get(0); page<=pageList.get(0)+1; page++){
            //error check
            if(page!=pageList.get(i)) return -1;
            i++;

            if(page <=1 || page >=399) return -1;
            List<Integer> allNumber = separate(page);
            if(allNumber.isEmpty()) return -1;
            int sum=0;
            int mul=1;
            for(int num : allNumber){
                sum+= num;
                mul*= num;
            }

            max = Math.max(sum, max); //모두 더하거나
            max = Math.max(sum, mul); //모두 곱하거나
        }
        return max;

    }

    private static List<Integer> separate(int page) {
        //page는 반드시 2 초과
        List<Integer> list = new ArrayList<>();
        if(page<=2) {return list;}
        if(page<10){
            int one = page;
            list.add(one);
        }
        else if(page>=10 && page<100){
            int one = page % 10;
            int ten = page / 10;
            list.add(ten);
            list.add(one);
        }else if(page>=100 && page <399){
            int one = page % 10;
            int ten = (page % 100) / 10; //141 % 100 = 41 /10 =4
            int hun = page / 100;
            list.add(hun);list.add(ten);list.add(one);
        }else {
            return list;
        }
        return list;
    }

    public static int winner(int pobi, int crong){
        if(pobi<0 || crong <0) return -1;
        // 예외 : return -1;
        if (pobi > crong){
            return 1;
        }else if(pobi < crong){
            return 2;
        }else{
            return 0;
        }
    }
}