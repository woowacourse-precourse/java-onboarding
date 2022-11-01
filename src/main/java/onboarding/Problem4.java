package onboarding;

import java.util.Scanner;

public class Problem4 {
    public static String solution(String word) {
        int num = 0;
        int abs_num,reverse;
        String answer = "";
        char[] list1 = word.toCharArray();

        for (int i = 0; i < list1.length; i++) {
            if (Character.isLowerCase(list1[i])) {
                num = 97;
            } else if (Character.isUpperCase(list1[i])) {
                num = 65;
            } else {
                answer = answer+' ';
                continue;
            }
            abs_num = Math.abs(num - list1[i]);
            reverse = (num + 25) - abs_num;
            answer = answer + String.valueOf((char) reverse);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        System.out.println(solution(num));

    }
}
