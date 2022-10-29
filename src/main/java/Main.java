import onboarding.Problem1;
import onboarding.Problem2;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Problem1.solution(Arrays.asList(97,98) ,Arrays.asList(197,198)));
//        System.out.println(Problem1.solution(Arrays.asList(131,132) ,Arrays.asList(211,212)));
//        System.out.println(Problem1.solution(Arrays.asList(99,102) ,Arrays.asList(211,212)));\
        int n = 2;
        String input = "0123456";
        for(int i = 0 ; i <= input.length() - n;i++)
        {
            System.out.println(input.substring(i,i+n));
        }

    }
}
