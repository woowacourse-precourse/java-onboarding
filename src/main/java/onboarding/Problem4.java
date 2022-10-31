package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer ="";
        if (checkLimit(word)) answer=reverseWord(word);
        return answer;
    }

    /*
    문제 조건 사항 체크
     */
    private static boolean checkLimit(String word){
        //문자열 1부터 1000까지
        if(word.length()>=1&&word.length()<=1000) return true;
        return false;
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
