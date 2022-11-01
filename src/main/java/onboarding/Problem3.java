package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String strNum;

       for(int i = 1; i <= number; i++) {
           strNum = Integer.toString(i);
           for (int j = 0; j < strNum.length(); j++) {
               if (strNum.charAt(j) == '3' || strNum.charAt(j) == '6' || strNum.charAt(j) == '9') {
                   answer++;
               }
           }
       }

        return answer;
    }
}
