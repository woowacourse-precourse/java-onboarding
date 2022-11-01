package onboarding;

import java.util.List;
class Problem1 {
    public static boolean check(List<Integer> pobi, List<Integer> crong){
        if(pobi.get(0)<=1||pobi.get(1)>=400||crong.get(0)<=1||crong.get(1)>=400){
            return false;
        }
        if(pobi.get(1)-pobi.get(0)!=1 || crong.get(1)-crong.get(0)!=1){
            return false;
        }
        if(pobi.get(0)%2!=1 || crong.get(0)%2!=1){
            return false;
        }
        return true;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(!check(pobi,crong))
            return -1;
        int pobi_max = 0;
        int crong_max = 0;
        for(int i=0;i<2;i++){
            int tmp = pobi.get(i);
            int sum=0;
            int mul = 1;
            while(tmp>0){
                sum+=tmp%10;
                mul*=tmp%10;
                tmp/=10;
            }
            pobi_max = Math.max(Math.max(sum,mul),pobi_max);

            tmp = crong.get(i);
            sum=0;
            mul=1;
            while(tmp>0){
                sum+=tmp%10;
                mul*=tmp%10;
                tmp/=10;
            }
            crong_max = Math.max(Math.max(sum,mul),crong_max);

        }
        if(crong_max>pobi_max){
            answer = 2;
        }
        else if(pobi_max > crong_max){
            answer = 1;
        }
        else {
            answer = 0;
        }
        return answer;
    }
}