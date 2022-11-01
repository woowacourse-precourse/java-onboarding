package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem3 {

    public static int solution(int number) {
        int clap = 0;
        for(int i = 1; i<=number; i++){
            String stringNumber = String.valueOf(i);
            for(char a : stringNumber.toCharArray()){
                if(a == '3' || a=='6' || a=='9' ){
                    clap++;
                }
            }
        }
        return clap;
    }
}
