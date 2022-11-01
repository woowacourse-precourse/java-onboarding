package onboarding;

import java.util.List;

class Problem1 {

    public static int maxOfNum(Integer num){
        int sum=0, mul=1;
        while(num != 0){
            sum+=num%10;
            mul*=num%10;
            num/=10;
        }
        return Math.max(sum, mul);
    }
    public static int maxOfPeople(List<Integer> list){
        return Math.max(maxOfNum(list.get(0)),maxOfNum(list.get(1)));
    }

    public static int winner(List<Integer> list1, List<Integer> list2){
        int check = maxOfPeople(list1)-maxOfPeople(list2);
        if(check>0) return 1;
        if(check<0) return 2;
        return 0;
    }
    public static boolean exception(List<Integer> list){
        Integer l1 = list.get(0);
        Integer l2 = list.get(1);
        if(l1%2==1 && l2%2==0 && l2-l1==1 && l1>=1 && l1<=400 && l2>=1 && l2<=400) return false;
        return true;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try{
            if(exception(pobi) || exception(crong)){
                answer=-1;
            }
            else{
                answer=winner(pobi,crong);
            }
        }catch(Exception e){
            answer=-1;
        }
        return answer;
    }
}