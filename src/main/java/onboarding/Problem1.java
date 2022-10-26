package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //pobi list에서 가장 큰 수
        int pobiMax = 0;
        int num1 = pobi.get(0);
        int num2 = pobi.get(1);
        int sum1 = 0;
        int sum2 = 0;
        int multi1 = 1;
        int multi2 = 1;
        for ( int i = 1 ; i <= 3 ; i++){
            int ten = (int) Math.pow(10, i);
            sum1 += (num1% ten)/(int)Math.pow(10,i-1);
            sum2 += (num2% ten)/(int)Math.pow(10,i-1);

            if (num1 == 0){
                multi1 *= 1;
            }
            else {
                multi1 *= (num1 % ten) / (int) Math.pow(10, i - 1);
            }

            if (num2 == 0){
                multi2 *= 1;
            }
            else{
                multi2 *= (num2 % ten)/(int)Math.pow(10,i-1);

            }
//            pobiMultiple *= sum;

            num1 -= (num1% ten);
            num2-= (num2% ten);

        }

        //pobi에서 합과 곱 중 더 큰 숫자를 반환
        if(sum1 >= sum2 && sum1 >= multi1 && sum1 >= multi2){
            pobiMax = sum1;
        }
        else if(sum2 >= sum1 && sum2 >= multi1 && sum2 >= multi2){
            pobiMax = sum2;
        }
        else if (multi1 >= sum1 && multi1 >= sum2 && multi1 >= multi2 ){
            pobiMax = multi1;
        }
        else if (multi2 >= sum1 && multi2 >= sum2 && multi2 >= multi1){
            pobiMax = multi2;
        }


        int crongMax = 0;
        int num3 = crong.get(0);
        int num4 = crong.get(1);
        int sum3 = 0;
        int sum4 = 0;
        int multi3 = 1;
        int multi4 = 1;

        for ( int i = 1 ; i <= 3 ; i++){
            int ten = (int) Math.pow(10, i);
            sum3 += (num3% ten)/(int)Math.pow(10,i-1);
            sum4 += (num4% ten)/(int)Math.pow(10,i-1);

            if (num3 == 0){
                multi3 *= 1;
            }
            else {
                multi3 *= (num3 % ten) / (int) Math.pow(10, i - 1);
            }

            if (num4 == 0){
                multi4 *= 1;
            }
            else{
                multi4 *= (num4 % ten)/(int)Math.pow(10,i-1);

            }
//            pobiMultiple *= sum;

            num3 -= (num3% ten);
            num4 -= (num4% ten);

        }

        //crong에서 합과 곱 중 더 큰 숫자를 반환
        if(sum3 >= sum4 && sum3 >= multi3 && sum3 >= multi4){
            crongMax = sum3;
        }
        else if(sum4 >= sum3 && sum4 >= multi3 && sum4 >= multi4){
            crongMax = sum4;
        }
        else if (multi3 >= sum3 && multi3 >= sum4 && multi3 >= multi4 ){
            crongMax = multi3;
        }
        else if (multi4 >= sum3 && multi4 >= sum4 && multi4 >= multi3){
            crongMax = multi4;
        }

        //Game set
        if (pobi.get(0)+1 != pobi.get(1) || crong.get(0) +1 != crong.get(1)){
            return -1;
        }
        if (pobiMax > crongMax){
            return 1;
        }else if (pobiMax == crongMax){
            return 0;
        }
//        else if (pobiMax < crongMax){
//            return 2;
//        }
        return 2;
    }


    public static void main(String[] args) {
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);

        System.out.println(solution(pobi,crong));

    }
}