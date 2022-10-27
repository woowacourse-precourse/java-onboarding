package onboarding;


/*
* 1. number를 10으로 나눈 몫 * 3 만큼 ++, number를 10으로 나눈 나머지 / 3 만큼 ++
* 2.
* 3. 1, 2 반복
*
* */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < Math.log10(number)+1; i++) {
            int tmpDigits = (int) Math.pow(10, i);
            answer += (number / tmpDigits) * 3 * (tmpDigits / 10); // 3921 -> 3 * 3 * 100
            answer += ((number - tmpDigits / 10) % tmpDigits) / (3 * (tmpDigits / 10)) * (tmpDigits / 10); // 3921 -> 3821 % 1000 -> 821 -> 2*100
            System.out.println((number / tmpDigits) * 3 * (tmpDigits / 10) + " 이거랑 " + ((number - tmpDigits / 10) % tmpDigits) / (3 * (tmpDigits / 10)) * (tmpDigits / 10) + " 이거 더함");
            char secondDigitsNumber = ((number % tmpDigits) + "").charAt(0);
            
            if (secondDigitsNumber == '3' || secondDigitsNumber == '6' || secondDigitsNumber == '9') {
                System.out.println(number % (tmpDigits / 10) + 1 + ": 이섀끼도 더함");
                answer += number % (tmpDigits / 10) + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(10000));
    }
}
