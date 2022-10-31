package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<word.length();i++){
            stringBuilder.append(getReverse(word.charAt(i)));
        }
        return stringBuilder.toString();
    }
    public static char getReverse(char x){
        //대문자
        if(x >= 65 && x <= 90){
            return (char)(78 + (78-x) - 1);
        }
        //소문자
        else if(x >= 97 && x <= 122){
            return (char)(110 + (110-x) - 1);
        }
        //그 외
        else{
            return x;
        }
    }
}
