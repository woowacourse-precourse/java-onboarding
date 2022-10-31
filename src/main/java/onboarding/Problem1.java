package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int calc(List<Integer> toCalc){
        Integer[] result= new Integer[2];
        int cnt=0;

        for(Integer e : toCalc){
            List<Integer> slice=new ArrayList<>();

            for(;e!=0;e/=10) slice.add(e%10);
            int sum=slice.stream().mapToInt(Integer::intValue).sum();

            int mult=1;
            for(Integer n: slice) mult*=n;

            result[cnt++]=Math.max(sum,mult);
        }
        return Math.max(result[0],result[1]);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //index exception
        int pobi_head=pobi.get(0);
        int crong_head=crong.get(0);
        if(pobi_head<=2||pobi_head>=398||crong_head<=2||crong_head>=398)
            return -1;

        //discontinuous page exception
        int pobi_tail=pobi.get(pobi.size()-1);
        int crong_tail=crong.get(crong.size()-1);
        if(pobi_tail-pobi_head!= 1 || crong_tail-crong_head!=1)
            return -1;

        //calculate & compare
        int pobi_result=calc(pobi), crong_result=calc(crong);

        if(pobi_result<crong_result) answer=2;
        else if(pobi_result>crong_result) answer=1;
        else answer=0;

        return answer;
    }


}