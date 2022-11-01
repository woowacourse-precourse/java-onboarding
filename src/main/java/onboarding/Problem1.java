package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
    public static int result(List<Integer> value){
        List<Integer> temp = new ArrayList<>();
        for (int v : value){
            String s = Integer.toString(v);
            int sum=0;
            for (int i =0; i<s.length(); i++) sum += Integer.parseInt(String.valueOf(s.charAt(i)));
            int mul=0;
            if (s.length()>1){
                mul=Integer.parseInt(String.valueOf(s.charAt(0)));
                for (int i =1; i<s.length(); i++){
                    mul*=Integer.parseInt(String.valueOf(s.charAt(i)));
                }
            }
            temp.add(Math.max(sum,mul));
        }
        return Math.max(temp.get(0),temp.get(1));
    }
}