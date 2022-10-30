package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    /*
    단어 알파벳 거꾸로 만들기
     */
    private static String reverseWord(String str){
        char ch[]=str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(Character.isAlphabetic(ch[i])){
                if(ch[i]>='A'&&ch[i]<='Z'){
                    ch[i]=(char)('Z'-ch[i]+'A');
                }else if(ch[i]>='a'&&ch[i]<='z'){
                    ch[i]=(char)('z'-ch[i]+'a');
                }else{
                    ch[i]=ch[i];
                }
            }
            ch[i]=ch[i];
        }
        return String.copyValueOf(ch);
    }
}
