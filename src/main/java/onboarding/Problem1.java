package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //
        if(!((int)pobi.get(0) >= 1 && (int)pobi.get(0) <= 400 && (int)pobi.get(1) >= 1 && (int)pobi.get(1) <= 400)){
            return -1;
        }
        if(!((int)crong.get(0) >= 1 && (int)crong.get(0) <= 400 && (int)crong.get(1) >= 1 && (int)crong.get(1) <= 400)){
            return -1;
        }
        if((int)pobi.get(0) % 2 != 1 || (int)crong.get(0) % 2 != 1 || (int)pobi.get(0) + 1 != (int)pobi.get(1) || (int)crong.get(0) + 1 != (int)crong.get(1) ){
            return -1;
        }
        //
        int sum_pobi = 0;
        int sum_crong = 0;
        int answer = Integer.MAX_VALUE;
        int tmp = 0;
        int tmp2 = 1;
        //
        String[] tmpA = Integer.toString((int)pobi.get(0)).split("");
        String[] tmpB = Integer.toString((int)pobi.get(1)).split("");
        for(String i : tmpA){
            tmp += Integer.parseInt(i);
            tmp2 *= Integer.parseInt(i);
        }
        sum_pobi = Math.max(tmp, tmp2);
        tmp = 0;
        tmp2 = 1;
        for(String i : tmpB){
            tmp += Integer.parseInt(i);
            tmp2 *= Integer.parseInt(i);
        }
        sum_pobi = Math.max(sum_pobi, Math.max(tmp,tmp2));
        //
        //
        tmp = 0;
        tmp2 = 1;
        tmpA = Integer.toString((int)crong.get(0)).split("");
        tmpB = Integer.toString((int)crong.get(1)).split("");
        for(String i : tmpA){
            tmp += Integer.parseInt(i);
            tmp2 *= Integer.parseInt(i);
        }
        sum_crong = Math.max(tmp, tmp2);
        //
        tmp = 0;
        tmp2 = 1;
        for(String i : tmpB){
            tmp += Integer.parseInt(i);
            tmp2 *= Integer.parseInt(i);
        }
        sum_crong = Math.max(sum_crong, Math.max(tmp,tmp2));
        //
        if(sum_pobi > sum_crong){
            answer = 1;
        }
        else if(sum_pobi < sum_crong){
            answer = 2;
        }
        else{
            answer = 0;
        }
        return answer;
    }
}