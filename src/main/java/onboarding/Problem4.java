package onboarding;

public class Problem4 {
    public static char changeAlphabetReverse(char ch){
        if(ch <= 90){
            return (char)((char)155 - ch);
        }
        return (char)((char)219 - ch);

    }

    public static String changeStringReverse(String str){
        String reverseString = "";
        char[] chars = str.toCharArray();
        for(int i = 0;i<str.length();i++){
            if(chars[i] == ' '){
                reverseString += ' ';
                continue;
            }
            reverseString += changeAlphabetReverse(chars[i]);
        }
        return reverseString;
    }

    public static String solution(String word) {
        String answer = "";
        answer = changeStringReverse(word);
        return answer;
    }
}
