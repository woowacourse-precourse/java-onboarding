
package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        int pMax = -1;
        int cMax = -1;

        if(pobi.get(1) - pobi.get(0) < 2 && crong.get(1) - crong.get(0) < 2){
            pMax = Math.max(calc(pobi.get(0)), calc(pobi.get(0)));
            cMax = Math.max(calc(crong.get(0)), calc(crong.get(0)));

            if(pMax == cMax){
                answer = 0;
            }else{
                if(pMax > cMax){
                    answer = 1;
                }else{
                    answer = 2;
                }
            }
        }
        return answer;
    }

    private static int calc(int num){
        int rtn = -1;
        int plus = 0;
        int multi = 1;
        String numStr = String.valueOf(num);
        for(int i = 0; i < numStr.length(); i++){
            plus += (int) numStr.charAt(i) - '0';
            multi *= (int)numStr.charAt(i) - '0';
        }
        rtn = Math.max(plus,multi);
        return rtn;
    }

}