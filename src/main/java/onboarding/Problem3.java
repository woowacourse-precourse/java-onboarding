package onboarding;

public class Problem3 {
    public static int solution(int number) {
        String num = "";
        int answer;

        for (int i =1; i <= number; i++) {
            num += String.valueOf(i);
        }

        String[] check = {"3", "6", "9"};
        String compare = new String(num);

        for (String n : check) {
            System.out.println(n);
            compare = compare.replace(n, "");
            System.out.println(compare);
        }

        answer = num.length() - compare.length();

        return answer;
    }
}
