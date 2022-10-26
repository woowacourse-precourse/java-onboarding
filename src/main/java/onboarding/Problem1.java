package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiscore = Math.max(pluscalculate(pobi.get(0)), pluscalculate(pobi.get(1)), multicalculate(pobi.get(0)), multicalculate(pobi.get(1)));
        int crongscore = Math.max(pluscalculate(crong.get(0)), pluscalculate(crong.get(1)), multicalculate(crong.get(0)), multicalculate(crong.get(1)));

        if(Error(pobi) == false | Error(crong) == false){
            return -1;
        }

        if (pobiscore > crongscore){
            return 1;
        } else if (pobiscore < crongscore) {
            return 2;
        } else{
            return 0;
        }

    }
    public static boolean Error(List<Integer> list){
        if(list.get(0) > 1 & list.get(1) < 400 & list.size() == 2) & (list.get(1) - list.get(0)) == &  list.get(0) % 2 ==1 & list.get(1) %2 ==0 ){
            return true;
        }else{
            return false;
        }

    }
    public static int pluscalculate(int pagenumber){
        int sum =0;
        while(pagenumber != 0){
            sum += pagenumber % 10;
            pagenumber /= 10;

        }
        return sum;
    }

    public static int multicalculate(int pagenumber){
        int sum = 1;
        while(pagenumber!=0){
            sum *= pagenumber % 10;
            pagenumber /= 10;
        }
        return sum;
    }
}