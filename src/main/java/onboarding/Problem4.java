package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String tmp = "";

        for (int i = 0; i < word.length(); i++){
            String alphabet = word.substring(i, i+1);

            char str = word.charAt(i);

            str = reverse(str);  // 대소문자 변환
            System.out.print(str);

            String string = String.valueOf(str);

            if ((int)str > 64 || (int)str < 91 || (int)str > 96 || (int)str >123){
                tmp += string;
            }
        }

        answer = tmp;

        return answer;
    }

    public static Character reverse(char str){    // 문자 거꾸로 바꾸기
        int ascii = (int)str;

        if (Character.isUpperCase(str)){
            ascii = 155-ascii;
        } else if (Character.isLowerCase(str)){
            ascii = 219-ascii;
        }
        return (char)ascii;
    }

}
