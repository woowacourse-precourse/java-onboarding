package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // 고민
        // char 를 넣을 것이냐, String 을 넣을 것이냐
        String answer = "";
        Antonym antonym = new Antonym();

        for (int i=0; i<word.length(); i++){
            answer += antonym.antonym(word.charAt(i));
        }
        // System.out.println(answer);
        return answer;
    }
}

class Antonym{
    public char antonym(char word){
        char result = ' ';
        int tmp = 25 - (word-65) * 2;
        result = (char) (word + tmp);
        return result;
    }
}