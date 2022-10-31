package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            int temp = i;
            ArrayList<Integer> arrNum = new ArrayList<>();
            while(temp>0){
                arrNum.add(temp % 10);
                temp /=10;
            }
            for(int j=0; j< arrNum.size(); j++){
                if(arrNum.get(j) == 3) answer++;
                if(arrNum.get(j) == 6) answer++;
                if(arrNum.get(j) == 9) answer++;
            }
        }
        return answer;
    }
}
