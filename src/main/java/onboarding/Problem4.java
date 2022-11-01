package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String result = "";
        int len = word.length();
        for(int i=0;i<len;i++){
            char w = word.charAt(i);
            int ascii = (int)w;
            if(65<=ascii&&ascii<=90){
                result += (char)(155-ascii);
            }
            else if(97<=ascii&&ascii<=122){
                result += (char)(219-ascii);
            }
            else{
                result = result + w;
            }
        }
        return result;
    }
}
//65~90 97~122
//155   219