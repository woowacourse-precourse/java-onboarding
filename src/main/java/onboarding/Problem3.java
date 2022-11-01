package onboarding;

import java.util.regex.Pattern;

public class Problem3 {
    public static int solution(int number) {

        int clap_count=0;

        for(int num=1;num<=number;num++){

            String StringTypeOfNum = String.valueOf(num);
            String[] eachDigitOfNumArray = StringTypeOfNum.split("");

            for(String eachDigitOfNum : eachDigitOfNumArray){
                if(Pattern.matches("[369]", eachDigitOfNum)){
                    clap_count++;
                }
            }

        }

        return clap_count;
    }


}
