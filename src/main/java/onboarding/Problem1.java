package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if ((pobi.get(1) - pobi.get(0))!=1 || (crong.get(1) - crong.get(0))!=1){
            answer=-1;
            return answer;
        }
        int pobiVal= result(pobi);
        int crongVal = result(crong);
        if (pobiVal > crongVal) answer=1;
        else if (pobiVal < crongVal) answer=2;
        else if (pobiVal == crongVal) answer=0;
        else
            answer=-1;
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