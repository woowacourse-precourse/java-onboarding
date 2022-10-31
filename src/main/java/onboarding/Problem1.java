package onboarding;

import java.util.List;

class Problem1 {

    public static int Sum(int number) {
        int Sum = 0;
        while(number > 0) {
            Sum += number%10;
            number /= 10;
        }
        return Sum;
    }

    public static int Product(int number) {
        int Product = 1;
        while(number > 0) {
            Product *= number%10;
            number/= 10;
        }
        return Product;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if((pobi.get(0)+1)<pobi.get(1) || (crong.get(0)+1)<crong.get(1) || pobi.get(0)> pobi.get(1) || crong.get(0)> crong.get(1)){
            return -1;
        }

        int Max_pobi_left = Sum(pobi.get(0))>=Product(pobi.get(0))?Sum(pobi.get(0)):Product(pobi.get(0));
        int Max_pobi_right = Sum(pobi.get(1))>=Product(pobi.get(1))?Sum(pobi.get(1)):Product(pobi.get(1));

        int Max_crong_left = Sum(crong.get(0))>=Product(crong.get(0))?Sum(crong.get(0)):Product(crong.get(0));
        int Max_crong_right = Sum(crong.get(1))>=Product(crong.get(1))?Sum(crong.get(1)):Product(crong.get(1));

        int Max_pobi = Max_pobi_left>=Max_pobi_right?Max_pobi_left:Max_pobi_right;
        int Max_crong = Max_crong_left>=Max_crong_right?Max_crong_left:Max_crong_right;

        if(Max_pobi==Max_crong){
            answer = 0;
        }

        else{
            answer = Max_pobi>Max_crong?1:2;
        }

        return answer;
    }
    
    public static void main (String [] args) {

        List<Integer> pobi = List.of(131, 132);
        List<Integer> crong = List.of(211, 212);

        Problem1 prob = new Problem1();
    	System.out.println(prob.solution(pobi, crong));
    }
}