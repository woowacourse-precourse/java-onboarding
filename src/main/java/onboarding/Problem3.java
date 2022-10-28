package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    public static int solution(int number) {
        ArrayList<String> array = new ArrayList<>();
        for(int i = 1; i < number + 1; i++){
            array.add(String.valueOf(i));
        }
        return getCount(array);
    }

    public static int getCount(ArrayList<String> array){
        int cnt = 0;
        for(String s: array){
            cnt += numberCount(s, '3') + numberCount(s, '6') + numberCount(s, '9');
        }
        return cnt;
    }

    public static int numberCount(String s, char num){
        return s.length() - s.replace(String.valueOf(num), "").length();
    }
}
