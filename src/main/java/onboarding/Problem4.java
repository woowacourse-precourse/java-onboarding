package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class constant{
    static final String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    static final String invalidArgument = "invalidArgument";
    static final int length = 26;

}
class validateString{
    public static boolean isLower(String alphabet){
        return alphabet.matches(alphabet.toLowerCase());
    }
    public static boolean isvalidLength(String word){
        return (word.length()>=1)&&(word.length()<=1000);
    }
    public static boolean isAlphabet(String alphabet){
        return alphabet.chars().allMatch(Character::isLetter);
    }
}
class frog{
    private int index;
    private int changedIndex;
    public void setIndex(int index){
        this.index = index;
    }
    public void setChangedIndex(int index){
        this.changedIndex = constant.length-index-1;
    }
    public static String changeCase(String word){
        List<String> list = Arrays.asList(word.split(""));
        word = list.stream()
                .map(i->(i==i.toLowerCase())?i.toUpperCase():i.toLowerCase())
                .collect(Collectors.joining());
        return word;
    }
    public String changeWord(String alphabet){
        if(validateString.isLower(alphabet)){
            setIndex(constant.lowerAlphabet.indexOf(alphabet));
            setChangedIndex(index);
            return constant.lowerAlphabet.substring(changedIndex,changedIndex+1);
        }
        setIndex(constant.upperAlphabet.indexOf(alphabet));
        setChangedIndex(index);
        return constant.upperAlphabet.substring(changedIndex,changedIndex+1);
    }
}
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
