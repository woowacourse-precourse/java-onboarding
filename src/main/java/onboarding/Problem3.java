package onboarding;

import java.util.ArrayList;
import java.util.List;
public class Problem3 {
    public static int solution(int number) {
        int answer=0;
        for(int i=1;i<=number;i++){
            answer+=getClapNumber(i);
        }
        return answer;
    }

    public static int getClapNumber(int number){
        List<Integer> digitList=getDigitList(number);
        int count=0;
        for (int digit:digitList){
            if(digit!=0&&digit%3==0) {
                count += 1;
            }
        }
        return count;
    }

    public static List<Integer> getDigitList(int number){
        List<Integer> digitList = new ArrayList<>();
        while(number!=0){
            digitList.add(number%10);
            number/=10;
        }
        return digitList;
    }
}
