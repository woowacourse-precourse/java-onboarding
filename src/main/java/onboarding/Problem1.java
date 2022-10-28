package onboarding;

import java.util.List;

class Problem1 {
    public Problem1(){

    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(listSizeException(pobi) || listSizeException(crong)){
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean listSizeException(List<Integer> list){
        return list.size() != 2;
    }
}