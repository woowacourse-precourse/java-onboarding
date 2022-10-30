package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        String dictCap = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String dictSmall = "zyxwvutsrqponmlkjihgfedcba";
        int num = 0;

        for(int i = 0;i<word.length();i++){

            if((int)word.charAt(i) == 32)
            {
                answer.append(" ");
                continue;
            }
            if(Character.isUpperCase(word.charAt(i)))
            {
                // 대문자
                num = (int)word.charAt(i) - 65;
                answer.append(dictCap.charAt(num));
                continue;
            }
            num = (int)word.charAt(i) - 97;
            answer.append(dictSmall.charAt(num));

        }

        return answer.toString();
    }


}
