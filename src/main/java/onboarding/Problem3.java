package onboarding;

import java.lang.Math;
import java.util.ArrayList;

public class Problem3 {

    public static int game(int n){
        int ans = 0;
        for (int j=0; j<=n; j++) {
            String oldList = Integer.toString(j);
            ArrayList<Integer> newList = new ArrayList<>();
            for (int i = 0; i < oldList.length(); i++) {
                newList.add(oldList.charAt(i) - '0');
            }
            for (int i : newList) {
                if (i == 3 || i == 6 || i == 9) {
                    ans += 1;
                }
            }
        }
        return ans;
    }

    public static int solution(int number) {
        int answer = 0;
        answer=game(number);
        return answer;
    }
}