package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int temp = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<word.length(); i++) {
            temp = ascii(word.charAt(i));

            if(temp!=0)
                sb.append(String.valueOf((char)temp));
            else
                sb.append(word.charAt(i));
        }

        answer = sb.toString();

        return answer;
    }

    // 대소문자 구별하여 변환
    public static int ascii(char ch) {
        int asc = 0;

        if(Character.isUpperCase(ch))
            asc = 65;
        else if(Character.isLowerCase(ch))
            asc = 97;
        else
            return 0;

        int abs = Math.abs(asc - ch);
        int reverse = (asc + 25) - abs;

        return reverse;
    }
}
