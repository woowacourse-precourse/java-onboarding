package onboarding;

import java.util.List;
import java.util.Objects;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if(!checkNumSize(number))
            return answer;

        for(int i =1; i<=number; i++){
            String cal = String.valueOf(i);
            String[] list = cal.split("");
            for(int j=0; j<list.length; j++){
                if(Objects.equals(list[j], "3")){
                    answer++;
                }
                if(Objects.equals(list[j], "6")){
                    answer++;
                }
                if(Objects.equals(list[j], "9")){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static boolean checkNumSize(int num){
        return num>0 && num < 10000;

    }
}
