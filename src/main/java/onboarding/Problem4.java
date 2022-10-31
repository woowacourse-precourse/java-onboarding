package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        if (word.length()<1 || word.length()>1000)
            return "error";

        for (int i = 0; i<word.length(); i++){
            answer += translateWord(word.charAt(i));
            System.out.println(answer);
        }

        return answer;
    }

    public static char translateWord(int alphabet){

        if(alphabet >=65 && alphabet <= 90){
            alphabet = 155 - alphabet;
        }else if(alphabet >=97 && alphabet <= 122){
            alphabet = 219 - alphabet;
        }
        System.out.println(alphabet);
        return (char) alphabet;
    }
}
