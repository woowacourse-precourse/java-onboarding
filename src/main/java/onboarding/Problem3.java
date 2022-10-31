package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        List<Integer> con = new ArrayList<>();
        con.add(3);
        con.add(6);
        con.add(9);
        for(int i=1; i<=number; i++){
            int num = i;
            do{
                if(con.contains(num%10)) answer++;
            }while((num/=10) > 0);
        }
        return answer;
    }
}
