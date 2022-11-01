package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuffer sb=new StringBuffer();
        sb.append(word);
        char toChange='a';
        for (int i=0;i<word.length();i++){
            int ascii=(int)word.toCharArray()[i];
            if ((65<=ascii && ascii<=90) ||(97<=ascii && ascii<=122)){
                if (65<=ascii && ascii<=90){
                    toChange=(char)(155-ascii);
                }
                else{ //97<=ascii && ascii<=122
                    toChange=(char)(219-ascii);
                }
                // replace
                sb.deleteCharAt(i);
                sb.insert(i,toChange);
            }
        }
        answer= String.valueOf(sb);
        return answer;
    }
}
