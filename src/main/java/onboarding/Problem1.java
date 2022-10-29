package onboarding;

import javax.swing.plaf.ListUI;
import java.util.List;

class Problem1 {
    public boolean checkNum(List<Integer> a, List<Integer> b){
        if (a.get(1) - a.get(0) == 1 && b.get(1) - b.get(0) == 1){
            return true;
        } else {
            return false;
        }
    }

    public int makeNum(List<Integer> numList){
        int maxNum = -1000000;
        for (int i: numList){
            int num1 = 1;
            int num2 = 1;

            String s = String.valueOf(i);
            for (int j=0; j < s.length(); j++){
                num1 += Integer.parseInt(s.substring(j, j+1));
                num2 *= Integer.parseInt(s.substring(j, j+1));
            }

            int temp = Math.max(num1, num2);
            maxNum = Math.max(maxNum, temp);
        }
        return maxNum;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem1 = new Problem1();

        if (problem1.checkNum(pobi, crong) != true){
            return -1;
        }

        int pobiNum = problem1.makeNum(pobi);
        int crongNum = problem1.makeNum(crong);
        int answer = Integer.MAX_VALUE;

        if (pobiNum > crongNum){
            answer = 1;
        } else if (pobiNum < crongNum) {
            answer = 2;
        } else if (pobiNum == crongNum) {
            answer = 0;
        }

        return answer;
    }
}