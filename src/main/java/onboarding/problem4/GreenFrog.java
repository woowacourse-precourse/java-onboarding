package onboarding.problem4;

public class GreenFrog {
    private char[] words;
    private StringBuilder greenFrogWord = new StringBuilder();

    public GreenFrog(String word){
        words = word.toCharArray();
    }

    public String conversionCase(){
        for(char word : words){
            if(word == ' '){
                greenFrogWord.append(' ');
                continue;
            }

            if('A' <= word && word <= 'Z'){
                greenFrogWord.append((char)('Z' - (word - 'A')));
            }
            else if('a' <= word && word <= 'z'){
                greenFrogWord.append((char)('z' - (word - 'a')));
            }
        }
        return greenFrogWord.toString();
    }
}
