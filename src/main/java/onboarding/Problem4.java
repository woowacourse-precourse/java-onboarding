package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] mylist=word.toCharArray();
        int n=0;

        for(char c:mylist){
            n=(int)c;
            if(n>=65 && n<=90){
                c=(char)(155-n);
            }else if(n>=97 && n<=122){
                c=(char)(219-n);
            }
            answer+=c;
        }

        return answer;
    }
}
