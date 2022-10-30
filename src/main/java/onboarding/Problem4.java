package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String blank="\\s+";
        String[] strings = word.split(blank);

        for(int i=0;i<strings.length;i++){
            strings[i]=changeAlpha(strings[i]);
        }

        return String.join(" ",strings);
    }
    public static String changeAlpha (String word){
        char[] chars=word.toCharArray();

        int upperSymmetrySum=(int)'A'+(int)'Z';
        int lowerSymmetrySum=(int)'a'+(int)'z';
        for(int i=0; i<chars.length; i++){
            if(Character.isUpperCase(chars[i]))chars[i]=symmetryChar(upperSymmetrySum,chars[i]);
            else chars[i]=symmetryChar(lowerSymmetrySum,chars[i]);
        }

        return String.valueOf(chars);
    }
    public static char symmetryChar(int symmetrySum, char c){
        return (char)(symmetrySum-(int)c);
    }
}
