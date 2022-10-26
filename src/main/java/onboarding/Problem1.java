package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiNum = 0;
        int crongNum = 0;
        int answer = Integer.MAX_VALUE;

        for (int i: pobi){
            int num1 = 0;
            int num2 =0;

            String s = String.valueOf(i);
            for (int j=0; j < s.length(); j++){
                num1 += Integer.parseInt(s.substring(j, j+1));
                num2 *= Integer.parseInt(s.substring(j, j+1));
            }

            int temp = Math.max(num1, num2);
            pobiNum = Math.max(crongNum, temp);
        }

        for (int i: crong){
            int num1 = 0;
            int num2 = 1;

            int temp = Math.max(num1, num2);
            crongNum = Math.max(pobiNum, temp);
        }

        if (pobiNum > crongNum){
            answer = 1;
        } else if (pobiNum < crongNum) {
            answer = 2;
        } else if (pobiNum == crongNum) {
            answer = 0;
        } else {
            answer = -1;
        }

        return answer;
    }
}