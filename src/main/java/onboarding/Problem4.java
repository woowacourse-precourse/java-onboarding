package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuffer result = new StringBuffer();

        for(char c : word.toCharArray()){
            if(Character.isAlphabetic(c)){
                result.append(convertToTreeFrogLanguage(c));
            }
            else{
                result.append(String.valueOf(c));
            }
        }

        return result.toString();
    }

    private static int getAsciiNumberOfzIsLowerCaseElseZ(char c){
        if(Character.isUpperCase(c)) return 'Z';

        return 'z';
    }

    private static String convertToTreeFrogLanguage(char c){
        return String.valueOf((char)(2*getAsciiNumberOfzIsLowerCaseElseZ(c)-c-25));
    }


}
