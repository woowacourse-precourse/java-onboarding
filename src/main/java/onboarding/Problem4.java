package onboarding;

import static java.lang.Character.isAlphabetic;

public class Problem4 {
    public static String solution(String sentence) {
        String blank="\\s+";
        String[] words = sentence.split(blank);

        for(int i=0;i<words.length;i++){
            words[i]=changeAlpha(words[i]);
        }

        return String.join(" ",words);
    }
    public static String changeAlpha (String word){
        char[] chars=word.toCharArray();

        int upperSymmetrySum=(int)'A'+(int)'Z';
        int lowerSymmetrySum=(int)'a'+(int)'z';
        for(int i=0; i<chars.length; i++){
            if(!isAlphabetic(chars[i]))continue;
            if(Character.isUpperCase(chars[i]))chars[i]=symmetryChar(upperSymmetrySum,chars[i]);
            else chars[i]=symmetryChar(lowerSymmetrySum,chars[i]);
        }

        return String.valueOf(chars);
    }
    public static char symmetryChar(int symmetrySum, char c){
        return (char)(symmetrySum-(int)c);
    }
}
