package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != ' '){
                int charValue = word.charAt(i);

                if(charValue <= 'Z' && charValue >= 'A'){ //대문자 A~Z일 경우
                    char ch = (char)('Z' - (charValue - 'A'));
                    sb.append(ch);
                }

                else if(charValue <= 'z' && charValue >= 'a'){ //소문자 a~z일 경우
                    char ch = (char)('z' - (charValue - 'a'));
                    sb.append(ch);
                }
            }
            else{
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
