package onboarding;

public class Problem3 {
    public static int solution(int number) {

        try {
            ExceptionProblem3.validateNumber(number);
        } catch (IllegalArgumentException e) {
            return 0;
        }

        String num = "";
        int answer;

        for (int i =1; i <= number; i++) {
            num += String.valueOf(i);
        }

        String[] check = {"3", "6", "9"};
        String compare = num;

        for (String n : check) {
            System.out.println(n);
            compare = compare.replace(n, "");
            System.out.println(compare);
        }

        answer = num.length() - compare.length();

        return answer;
    }
}

class ExceptionProblem3 {
    public static void validateNumber(int number) {
        if (number < 1 || number > 10000) {
            throw new IllegalArgumentException();
        }
    }
}
