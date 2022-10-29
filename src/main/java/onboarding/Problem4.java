package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    public static char upper(char alphabet){
        char answer;
        if(alphabet>77){
           answer= (char) (77-(alphabet-78));
           return answer;

        } else if(alphabet==77){
            answer=77;
            return 77;
        } else {return answer = (char) (77+(77 - alphabet+1));}
    }
}
