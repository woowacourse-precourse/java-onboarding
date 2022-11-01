package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int oneNumClap(int num){
        int count = 0;
        ArrayList<Integer> numArr = new ArrayList<>();
        while (num!=0){
            numArr.add(num%10);
            num/=10;
        }
        for(int i=0; i<numArr.size(); i++){
            if(numArr.get(i)==3 || numArr.get(i)==6 || numArr.get(i)==9){
                count++;
            }
        }
        return count;
    }
    public static int solution(int number) {
        if(number<1 || number>10000){
            return 0;
        }
        int answer = 0;
        for(int i=0; i<number; i++){
            answer += oneNumClap(i+1);
        }
        return answer;
    }
}
