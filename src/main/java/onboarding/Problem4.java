package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuffer sb = new StringBuffer();
        char[] chars = word.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(!Character.isAlphabetic(chars[i])) sb.append(chars[i]);
            if(Character.isUpperCase(chars[i])){
                int charNum='Z'-chars[i]+'A';
                sb.append((char)charNum);
            }
            if(Character.isLowerCase(chars[i])){
                int charNum='z'-chars[i]+'a';
                sb.append((char)charNum);
            }
        }
        return sb.toString();
    }
}
