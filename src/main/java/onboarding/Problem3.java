package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int digit = 10000;

        int answer = 0;

        int num = number;
        while(digit >= 10){
            int quotient = num / digit;
            for(int i = 0; i <= quotient; i++){
                System.out.println("i = " + i + ", num / digit = " + num + " / " + digit);

                int rest = num - (i * digit);

                if(rest < 10){
                    System.out.println(num + " - (" + i + " * " + digit + ") == " + (num - (i * digit)));
                    // 마지막
                    if(i % 3 == 0 && i > 0){

                        answer += (rest + 1);
                        System.out.println(rest + 1 + ", " + answer);
                    }

                    answer += rest / 3;
                    System.out.println(rest / 3  +" , " + answer);
                    return answer;

                }else{
                    if(quotient > 0) {
                        if (i % 3 == 0 && i > 0) {
                            answer += 10;
                        } else {
                            answer += 3;
                        }
                    }
                }

                System.out.println("answer = " + answer);
            }

            num %= digit;
            digit /= 10;
        }

        return answer;
    }


    public static void main(String[] args) {
        int a = solution(33);
//        int b = solution(9);

        System.out.println(a);
//        System.out.println(b);
    }
}
