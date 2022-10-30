package onboarding;

import java.util.List;
import java.lang.String;

class Problem1 {
    public static int cal(String n1, String n2){
        int add_n1 = 0, mul_n1 = 1, max_n1 = 0;
        int add_n2 = 0, mul_n2 = 1, max_n2 = 0;
        int max_n;

        for(int i=0; i<n1.length(); i++) {
            add_n1 += n1.charAt(i) - '0';
            mul_n1 *= n1.charAt(i) - '0';

            add_n2 += n2.charAt(i) - '0';
            mul_n2 *= n2.charAt(i) - '0';
        }
        max_n1 = Math.max(add_n1, mul_n1);
        max_n2 = Math.max(add_n2, mul_n2);
        max_n = Math.max(max_n1, max_n2);

        return max_n;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(pobi.get(0) % 2 == 1 && (pobi.get(1) % 2 == 0 && pobi.get(0) + 1 == pobi.get(1))))
            return -1;

        if (!(crong.get(0) % 2 == 1 && (crong.get(1) % 2 == 0 && crong.get(0) + 1 == crong.get(1))))
            return -1;

        String p1 = pobi.get(0).toString();
        String p2 = pobi.get(1).toString();
        String c1 = crong.get(0).toString();
        String c2 = crong.get(1).toString();
        int answer = Integer.MAX_VALUE;

        int ans_pobi = 0, ans_crong = 0;

        ans_pobi = cal(p1, p2);
        ans_crong = cal(c1, c2);

        if (ans_pobi > ans_crong){
            answer = 1;
        }
        else if(ans_pobi < ans_crong){
            answer = 2;
        }
        else{
            answer = 0;
        }

        return answer;
    }

//    public static void main(String[] args){
//        solution();
//        System.out.println("Hello");
//    }
}