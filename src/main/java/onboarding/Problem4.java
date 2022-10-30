package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        if (word.length()<1 || word.length()>1000)
            return "Invalid Input";

        for (int i = 0; i<word.length(); i++){
            int alphabet = word.charAt(i);
            if(alphabet >=65 && alphabet <= 90){
                alphabet = 155 - alphabet;
            }else if(alphabet >=97 && alphabet <= 122){
                alphabet = 219 - alphabet;
            }
            answer += (char)alphabet;
        }

        return answer;
    }
}
