package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Integer[] page  = {randomNum(),randomNum()+1};
        pobi = new ArrayList<>(Arrays.asList(page));
        crong = new ArrayList<>(Arrays.asList(page));


        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static Integer randomNum(){
        Random random = new Random();
        Integer randomNum  = 0;
        randomNum = 2*random.nextInt(401)+1;
        return randomNum;
    }

    public static int sum(Integer a){
        int sum = 0;
        while(a != 0){
           sum += a%10;
           a /= 10;
        }return sum;
    }

    public static int multi(Integer a){
        String str = String.valueOf(a);
        int [] num = new int[str.length()];
        Integer multi = 0;
        for(int i = 0; i<str.length(); i++){
            for(int k = 0; k<str.length(); k++){
                String b = str.substring(i,i+1);
               num [k]= Integer.parseInt(b);
               multi = num[k] * num[k+1];
            }
        }return multi;
    }


}