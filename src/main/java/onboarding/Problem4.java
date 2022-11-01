package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] asc = new char[word.length()];

        for(int i=0; i<word.length(); i++){
            if('a'<= word.charAt(i) && 'z'>= word.charAt(i)){
                asc[i] = (char)('z' - (word.charAt(i) -'a'));
            }
            else if('A'<= word.charAt(i) && 'Z'>= word.charAt(i)){
                asc[i] = (char)('Z' - (word.charAt(i) -'A'));
            }
            else{
                asc[i]=word.charAt(i);
            }
        }

        String answer = "";

        return answer;
    }

}
