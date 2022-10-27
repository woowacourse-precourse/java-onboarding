package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
       answer=(int) IntStream.rangeClosed(1,number).filter(i->i%10==3||i%10==6||i%10==9).count()+
                (int)IntStream.rangeClosed(1,number).filter(i->i/10==3||i/10==6||i/10==9).count();
        return answer;
    }
}
