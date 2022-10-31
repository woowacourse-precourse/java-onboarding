package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <=number ; i++) {
            answer += checkVal(String.valueOf(i));
        }
        return answer;
    }
    public static int checkVal(String s){
        int result = 0;
        List<String> list = new LinkedList<>(List.of(s.split("")));
        for(String i : list){
            if(i.equals("3")||i.equals("6")||i.equals("9")) result++;
        }
        return result;
    }
}
