package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        System.out.println("--------");
        answer = eliminate(cryptogram,0,Character.MIN_VALUE, false);

        System.out.println(answer);
        System.out.println("zz".substring(0,0));
        return answer;
    }

    private static String eliminate(String cryptogram, int index, char before, boolean founded){
        System.out.println("!!!!");
        System.out.println(index);
        System.out.println(cryptogram);
        if(index + 1 >= cryptogram.length()){
            System.out.println("???");
            if(founded==true) {
                return eliminate(cryptogram,0, Character.MIN_VALUE, false);

            }
            else return cryptogram;
        }
        else{
            char current = cryptogram.charAt(index);

            if(before == current){
                System.out.println("!!!");
                System.out.println(index);
                String part1 = cryptogram.substring(0, index-1);
                String part2 = cryptogram.substring(index+1);
                System.out.println("#################");
                System.out.println(part1);
                System.out.println(part2);
                System.out.println("#################");
                return eliminate(part1+part2, index-1, current, true);
            }
            else
                return eliminate(cryptogram, index+1, current, founded);
        }
    }
}
