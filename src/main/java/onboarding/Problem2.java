package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2 {
    //    List[] list1 = new ArrayList<String>;
    public static String solution(String cryptogram) {
        String answer = ""  ;
        //해당 문자 중복 값 있는지?check용 함수
        while (!check(cryptogram)) {
            answer = delete(cryptogram);
            cryptogram = answer;
        }
        return answer;
    }

    public static boolean check(String cryptogram) {
        int sum = 0;
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static String delete(String cryptogram) {
        String ans = " ";
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
                ans = cryptogram.substring(0, i-1) + cryptogram.substring(i + 1);
            }
        }
        return ans;

    }}