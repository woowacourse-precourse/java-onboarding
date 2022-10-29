package onboarding;


public class Problem3_2 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < Math.log10(number)+1; i++) {
            int tmpDigits = (int) Math.pow(10, i);
            answer += (number / tmpDigits) * 3 * (tmpDigits / 10); // 3921 -> 3 * 3 * 100
            answer += (number % tmpDigits) / (3 * (tmpDigits / 10)) * (tmpDigits / 10); // 3921 -> 3821 % 1000 -> 821 -> 2*100
//            System.out.println((number / tmpDigits) * 3 * (tmpDigits / 10) + " 이거랑 " + ((number - tmpDigits / 10) % tmpDigits) / (3 * (tmpDigits / 10)) * (tmpDigits / 10) + " 이거 더함");
            char secondDigitsNumber = ((number % tmpDigits) + "").charAt(0);
            
            if (secondDigitsNumber == '3' || secondDigitsNumber == '6' || secondDigitsNumber == '9') {
//                System.out.println(tmpDigits / 10 - (number % (tmpDigits / 10) + 1) + ": 뺌");
                answer -= tmpDigits / 10 - (number % (tmpDigits / 10) + 1);
            }
        }

        return answer;
    }

    public static int solution2(int number) {
        int answer =0;
        for (int i = 1; i < number + 1; i++) {
            answer += count369(i);
        }

        return answer;
    }

    private static int count369(int n) {
        String str = n + "";
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char tmpchar = str.charAt(i);
            if (tmpchar == '3' || tmpchar == '6' || tmpchar == '9') answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution2(13));
    }
}
