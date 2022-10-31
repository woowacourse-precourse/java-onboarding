package onboarding;

import java.util.Map;

public class Problem3 {
    public static int count369(int num){
        Map<Integer, Integer> myMap = Map.of(
                0,0,
                1,0,
                2,0,
                3,1,
                4,1,
                5,1,
                6,2,
                7,2,
                8,2,
                9,3);

        if(num < 10){
            return myMap.get(num);
        }

        String stringNum =  Integer.toString(num);
        int n = Integer.parseInt(stringNum.substring(0,1));
        int m = stringNum.length()-1;
        int numWithoutn = Integer.parseInt(stringNum.substring(1));

        double subtotal = n*m*3*Math.pow(10,m-1) + myMap.get(n-1)*Math.pow(10,m) + ((n==3||n==6||n==9) ? 1 : 0)*(numWithoutn+1);
        int total = count369(numWithoutn) + (int)subtotal;

        return total;
    }

    public static int solution(int number) {
        int answer = count369(number);
        return answer;
    }
}
