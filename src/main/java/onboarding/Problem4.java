package onboarding;

class ReverseGenerator{
    private String word;
    private StringBuilder reversed;

    public ReverseGenerator(String word) {
        this.word = word;
        this.reversed = new StringBuilder();
    }

    private char getReverseChar(char c){
        if(c == ' ')return c;
        if(Character.isLowerCase(c))return (char) ('z' - (c - 'a'));
        return (char) ('Z' - (c - 'A'));

    }

    public String getReversed(){
        for(int i = 0; i < word.length(); i++){
            reversed.append(getReverseChar(word.charAt(i)));
        }
        return reversed.toString();
    }
}
public class Problem4 {
    public static String solution(String word) {
        ReverseGenerator generator = new ReverseGenerator(word);
        return generator.getReversed();
    }
}
