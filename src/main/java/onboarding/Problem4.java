package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        if(validateCheck(word)) {
            answer = changeString(word);
        }
        else {
            answer = "";
        }
        return answer;
    }
    private static boolean validateCheck(String word){
        for(int i=0; i<word.length(); i++){
            if((word.charAt(i) <'A' && word.charAt(i) > 'Z') ||
                    (word.charAt(i) < 'a' && word.charAt(i) > 'Z')) {
                return false;
            }
        }
        return true;
    }
    private static String changeString(String word){
        char lowerA = 'a';
        char lowerZ = 'z';
        char upperA = 'A';
        char upperZ = 'Z';
        String answer = "";
        for(int i=0; i<word.length(); i++){
            char cmp = word.charAt(i);
            if(cmp >= upperA && cmp <= upperZ){
                cmp = (char)(upperZ - cmp + upperA);
            }
            else if(cmp >= lowerA && cmp <= lowerZ){
                cmp = (char)(lowerZ - cmp + lowerA);
            }
            else {
                cmp = ' ';
            }
            answer += cmp;
        }
        return answer;
    }
}
