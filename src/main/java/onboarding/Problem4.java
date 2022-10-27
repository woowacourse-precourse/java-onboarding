package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i=0;i<word.length();i++){
            answer += changeAlphabet(word.charAt(i));
        }

        return answer;
    }

    public static char changeAlphabet(char ch){
        if(('A'>ch || ch>'Z') && ('a'>ch || ch>'z'))
            return ch;

        int change;
        if('A'<=ch && ch<='M'){
            change = ('M'-ch) * 2 + 1;
        }
        else if('N'<=ch && ch<='Z'){
            change = ('N'-ch) * 2 - 1;
        }
        else if('a'<=ch && ch<='m'){
            change = ('m'-ch) * 2 + 1;
        }
        else{
            change = ('n'-ch) * 2 - 1;
        }
        return (char) (ch + change);
    }
}
