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

        int pobisum = sum(pobi.get(0), pobi.get(1));
        int pobimulti = multi(pobi.get(0),pobi.get(1));
        int crongsum = sum(crong.get(0),crong.get(0));
        int crongmulti = multi(crong.get(0),crong.get(1));

        int pobiMax = Math.max(pobisum,pobimulti);
        int crongMax = Math.max(crongsum,crongmulti);







        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static Integer randomNum(){
        Random random = new Random();
        Integer randomNum  = 0;
        randomNum = 2*random.nextInt(400)+3;
        return randomNum;
    }

    public static int sum(Integer a, Integer b){
        int [] sum1 = new int [2];
        int answer = 0;
        while(a != 0 && b !=0){
                 sum1[0]+= a%10;
                 sum1[1]+= b%10;
                 b /= 10;
                 a /= 10;


        }return answer = Math.max(sum1[0],sum1[1]);
    }

    public static int multi(Integer a, Integer b){
        int multi = 0;
       if(a == 99){
           int a1 = a/10%10;
           int a2 = a/10;
           int b1 = b/100%10;
           int b2 = b/10%10;
           int b3 = b/10;
           multi = Math.max((a1*a2),(b1*b2*b3));
       }else if (a<99){
           int a1 = a/10%10;
           int a2 = a/10;
           int b1 = b/10%10;
           int b2 = b/10;
            multi = Math.max((a1*a2),(b1*b2));
       }else if(a>100){
           int a1 = a/10%10;
           int a2 = a/10;
           int a3 = a/100%10;
           int b1 = b/100%10;
           int b2 = b/10%10;
           int b3 = b/10;
           multi = Math.max((a1*a2*a3),(b1*b2*b3));
       }
       return multi;
    }


}