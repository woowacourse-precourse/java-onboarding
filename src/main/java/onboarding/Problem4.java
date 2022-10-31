package onboarding;



public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<word.length();i++){
            answer.append(wordChange(word.charAt(i)));
        }
        return answer.toString();
    }
    static char wordChange(char singleword){
        final int BIGALPSTART = 65;
        final int BIGALPEND = 90;
        final int SMALLALPSTART = 97;
        final int SMALLALPEND = 122;
        int asky_code = singleword;

        if(BIGALPSTART<=asky_code && asky_code<=BIGALPEND){
            asky_code = BIGALPSTART+BIGALPEND-asky_code;
        }else if(SMALLALPSTART<=asky_code && asky_code<=SMALLALPEND){
            asky_code = SMALLALPSTART+SMALLALPEND-asky_code;
        }
        singleword = (char)asky_code;
        return singleword;
    }
}
