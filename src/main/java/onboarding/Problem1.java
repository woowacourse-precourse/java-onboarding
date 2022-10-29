package onboarding;

import java.util.List;

class Problem1 {

    private static int findGameValue(List<Integer> ls){
        if(ls.size() != 2) throw new Error("list out of Index");

        int a = ls.get(0);
        int b = ls.get(1);

        if( b != a+1 ) throw new Error("two value is not consecutive");
        if(a%2 == 0 || b%2 == 1) throw new Error("(first, second) value must be (odd,even)");

        int x = Math.max(sumOfDigits(a), productOfDigits(a));
        int y = Math.max(sumOfDigits(b), productOfDigits(b));

        return Math.max(x,y);
    }

    private static int sumOfDigits(int v){
        int k = v, result = 0;
        while(k > 10) {
            result += (k%10);
            k = k/10;
        }
        result += k;
        return result;
    }

    private static int productOfDigits(int v){
        int k = v, result = 1;
        while(k > 10){
            result *= (k%10);
            k = k/10;
        }
        result *= k;
        return  result;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        try {
            int valueOfPobi = findGameValue(pobi);
            int valueOfCrong = findGameValue(crong);

            if (valueOfPobi > valueOfCrong) {
                return 1;
            } else if (valueOfPobi < valueOfCrong) {
                return 2;
            } else {
                return 0;
            }
        } catch (Error e) {
            return -1;
         }
    }

}