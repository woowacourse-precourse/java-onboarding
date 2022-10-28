package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] Problem6) {

//        String s = "aaaaaaab";
//        String ss = Problem2.solution(s);
//        System.out.println("ss = " + ss);

//        int sss = Problem3.solution(13);
//        System.out.println("args = " + sss);
//
//        String aa = Problem4.solution("A B0231");
//        System.out.println("aa = " + aa);
//        Problem5.solution(1234567);

        if(onboarding.Problem6.isEmail("aa12345678@email.com")){
            System.out.println("이메일 형식 통과");
        }else{
            System.out.println("이메일 형식 통과 못함");
        }
    }
}
