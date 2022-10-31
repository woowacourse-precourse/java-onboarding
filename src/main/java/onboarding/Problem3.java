package onboarding;

import java.util.Set;

public class Problem3 {

    private static final Set<Integer> CLAP = Set.of(3,6,9);
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number;i++) {
            answer+= getClapCount(i);
        }
        return answer;
    }

    public static int getClapCount(int num){
        int count = 0;
        while(num!=0){
            if(CLAP.contains(num%10)) count++;
            num/=10;
        }
        return count;
    }
}
