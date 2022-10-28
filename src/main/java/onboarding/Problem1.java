package onboarding;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

class Problem1 {
    static ArrayList<Integer> pars(Integer num){
        ArrayList<Integer> parsed_num=new ArrayList<Integer>();
        while(num!=0){
            parsed_num.add(num%10);
            num/=10;
        }
        return parsed_num;
    }
    static int cal(ArrayList<Integer> parsed_num){
        int sum=0,mul=1;
        for(Integer i:parsed_num){
            sum+=i;
            mul*=i;
        }
        return sum>mul?sum:mul;
    }
    static int larger(int num1, int num2){
        return num1>num2?num1:num2;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if ((pobi.get(1)-pobi.get(0)!=1)||(crong.get(1)-crong.get(0)!=1))
            return -1;
        if(larger(cal(pars(pobi.get(0))),cal(pars(pobi.get(1))))>larger(cal(pars(crong.get(0))),cal(pars(crong.get(1)))))
            answer=1;
        else if (larger(cal(pars(pobi.get(0))),cal(pars(pobi.get(1))))<larger(cal(pars(crong.get(0))),cal(pars(crong.get(1)))))
            answer=2;
        else if (larger(cal(pars(pobi.get(0))),cal(pars(pobi.get(1))))==larger(cal(pars(crong.get(0))),cal(pars(crong.get(1)))))
            answer=0;

        return answer;
    }
}