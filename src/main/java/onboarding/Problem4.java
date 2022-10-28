package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            if(String.valueOf(word.charAt(i)).matches("^[a-zA-Z]*$")){
                if(Character.isUpperCase(word.charAt(i))){
                    sb.append((char)(-word.charAt(i) + 155));
                }else{
                    sb.append((char)(-word.charAt(i) + 219));
                }
            }else{
                sb.append(word.charAt(i));
            }
        }
        answer = sb.toString();
        return answer;
    }
}
