package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i=0; i<word.length(); i++){
            if((int)word.charAt(i)>=97 && (int)word.charAt(i)<=122){
                    answer += (char)(97+122-(int)word.charAt(i));
            }
            else if((int)word.charAt(i)>=65 && (int)word.charAt(i)<=90){
                    answer += (char)(65+90-(int)word.charAt(i));
            }
            else answer += word.charAt(i);
        }

        return answer;
    }

    public static void main (String [] args) {

        String word = "I love you";

        Problem4 prob = new Problem4();
        System.out.println(prob.solution(word));
    }

}
