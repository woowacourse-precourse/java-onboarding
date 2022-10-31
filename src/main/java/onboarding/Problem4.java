package onboarding;

public class Problem4 {
    public static Character Reverse(char word){
        int temp;
        if(word >= 'a' && word<= 'z'){
            temp = (int)word - 'a';
            word = (char)((int)'z' - temp);
        }
        else if(word >= 'A' && word <= 'Z'){
            temp = (int)word - 'A';
            word = (char)((int)'Z' - temp);
        }
        return word;
    }
    public static String Reverse_Frog(String word){
        String answer = "";
        for(int i = 0 ; i < word.length(); i++){
            answer += Reverse(word.charAt(i));
        }
        return answer;
    }
    public static String solution(String word) {
        String answer = Reverse_Frog(word);
        return answer;
    }
}
