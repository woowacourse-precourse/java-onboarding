package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++){
            char alphabet = word.charAt(i);

            if(alphabet >=65 && alphabet <= 90){
                answer += (char)(155 - alphabet);
            }
            else if(alphabet <= 122 && alphabet >= 97){
                answer += (char)(219 - alphabet);
            }
            else answer += alphabet;
        }
        return answer;
    }
}

