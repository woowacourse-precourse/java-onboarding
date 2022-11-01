package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] rev = word.toCharArray();
        int a, b, re =0;
        String answer = "";

        for(int i = 0; i < rev.length; i++) {
            if(Character.isUpperCase(rev[i])){
                a =65;
            } else if (Character.isLowerCase(rev[i])) {
                a = 97;
            }else{
                answer=answer + ' ';
                continue;
            }
            b = Math.abs(a - rev[i]);
            re = (a + 25) - b;
            answer = answer + String.valueOf((char) re);
        }

        return answer;
    }
}
