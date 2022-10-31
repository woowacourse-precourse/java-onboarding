package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
            return -1;
        }

        if((pobi.get(0) <= 1 || pobi.get(0) >= 399) || (pobi.get(1) <= 2 || pobi.get(1) >= 400)){
            return -1;
        }

        if((crong.get(0) <= 1 || crong.get(0) >= 399) || (crong.get(1) <= 2 || crong.get(1) >= 400)){
            return -1;
        }

        if(pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0 || pobi.get(1) % 2 == 1 || crong.get(1) % 2 == 1) {
            return -1;
        }

        int pobi_num = Math.max(max_value(pobi.get(0)), max_value(pobi.get(1)));
        int crong_num = Math.max(max_value(crong.get(0)), max_value(crong.get(1)));

        if(pobi_num > crong_num){
            return 1;
        }
        else if (crong_num > pobi_num) {
            return 2;
        }
        else {
            return 0;
        }
        }
    public static int max_value(int number){
        String[] letters = String.valueOf(number).split("");
        int summation = 0;
        int multiply = 1;

        for (int i = 0; i < letters.length; i++){
            summation = summation + Integer.valueOf(letters[i]);
            multiply = multiply * Integer.valueOf(letters[i]);
        }

        int result = Math.max(summation, multiply);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> pobi = new ArrayList<>();
        pobi.add(97);
        pobi.add(98);
        List<Integer> crong = new ArrayList<>();
        crong.add(197);
        crong.add(198);
        System.out.println(solution(pobi, crong));
    }
}