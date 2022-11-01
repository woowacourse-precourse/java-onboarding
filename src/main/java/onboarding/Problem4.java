package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] chars = word.toCharArray();
        for(int i = 0;i<word.length();i++){
            char c = chars[i];
            if(Character.isAlphabetic(c)){
                if(Character.isUpperCase(c)){
                    chars[i] = (char)('A' + 'Z' - c);
                }else{
                    chars[i] = (char)('a' + 'z' - c);
                }
            }
        }
        answer = String.valueOf(chars);

        return answer;
    }
}
