package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char change = 'a';
        for(int i = 0 ; i < word.length(); i++){
            int asc = (int) word.charAt(i);
            if((65 <= asc && asc <= 90)){ // 'a' + 'z'
                change = (char)(155 - asc);
            }
            else if((97 <= asc && asc <= 122)){ // 'A' + 'Z'
                change = (char)(219 - asc);
            }
            else{
                change = ' ';
            }
            answer += change;
        }
        return answer;
    }
}
