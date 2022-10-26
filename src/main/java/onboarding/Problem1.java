package onboarding;

import java.util.List;

class Problem1 {
    static int sumStringToInteger(String n1){
        int n = 0;
        for(int i=0; i<n1.length(); i++){
            n += n1.charAt(i) - '0';
        }
        return n;
    }
    static int mulStringToInteger(String n1){
        int n = 1;
        for(int i=0; i<n1.length(); i++){
            n *= n1.charAt(i) - '0';
        }
        return n;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(0) != pobi.get(1) -1 || crong.get(0) != crong.get(1)-1){
            return -1;
        }


        return answer;
    }
}