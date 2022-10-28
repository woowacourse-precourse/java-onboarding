package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return reverseStr(word);
    }

    private static String reverseStr(String word){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c=word.charAt(i);
            int idx=-1;
            if(c>='a'&&c<='z'){
                idx=c-'a';
                idx=25-idx;
                char newC= (char) ('a'+idx);
                sb.append(newC);
            }else if(c>='A'&&c<='Z'){
                idx=c-'A';
                idx=25-idx;
                char newC= (char) ('A'+idx);
                sb.append(newC);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
