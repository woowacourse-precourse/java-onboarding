package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=0; i<=number ; i++)
            answer += Clap_count(i);
        return answer;
    }

    // 3 6 9 체크리스트
    private static List<Integer> threesixnine = new ArrayList<>(Arrays.asList(3, 6, 9));

    private static int Clap_count(int num){
        int cnt = 0;
        while(num > 0) {
            if(threesixnine.contains(num%10))
                cnt ++;
            num = num/10;
        }
        return cnt;
    }
}