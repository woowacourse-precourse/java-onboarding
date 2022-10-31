package onboarding;

public class Problem4 {
    /**
     * 소문자 ,대문자 문자 전환 함수
     * 문자열 전환 함수
     */
    public static String solution(String word) {
        return convert(word);
    }

    /*
     *소문자, 대문자 전환 함수
     */
    static char ch_convert(char ch){
        String up = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String low = "abcdefghijklmnopqrstuvwxyz";

        char result;
        if(Character.isUpperCase(ch)){
            result =  up.charAt(25 - ch + 'A');
        }else if(Character.isLowerCase(ch)){
            result = low.charAt(25 - ch + 'a');
        }else{
            result=' ';
        }
        return result;
    }

    /*
     *문자열 전환 함수
     */
    static String convert(String word){
        String convert = "";
        for(int i=0;i<word.length();i++){
            convert = convert + ch_convert(word.charAt(i));
        }
        return convert;
    }
}
