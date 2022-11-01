package onboarding;

public class Problem4 {
    public static String convert(String word){
        String answer = "";
        for(int i=0; i<word.length(); i++){
            if(Character.isLowerCase(word.charAt(i))){
                answer += (char)(219-word.charAt(i));
            }else if(Character.isUpperCase(word.charAt(i))){
                answer += (char)(155-word.charAt(i));
            }else{
                answer += (char)word.charAt(i);
            }
        }
        return answer;
    }

    public static String solution(String word) {
        if(word.length()<1 || word.length()>1000){
            return word;
        }
        return convert(word);
    }
}
