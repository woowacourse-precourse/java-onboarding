package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        int num = 0;
        int idx = 0;

        for(int i = 0;i<word.length();i++){
            idx = word.charAt(i);

            if(idx == 32)
            {
                answer.append(" ");
                continue;
            }
            if(Character.isUpperCase(idx))
                num = idx + 25 - ((idx-65)*2);
            else
                num = idx + 25 - ((idx-97)*2);

            answer.append((char)num);

        }

        return answer.toString();
    }


}
