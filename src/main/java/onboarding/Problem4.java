package onboarding;
import java.util.Arrays;
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] mom = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r',
                's','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M'
                ,'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] son = new char[52];
        for(int i = 0; i<26; i++){
            son[i] = mom[25-i];
        }
        for(int i = 0; i<26; i++){
            son[26+i] = mom[51-i];
        }
        for(int i = 0; i<word.length(); i++){
            int index = -1;
            for(int j = 0; j<mom.length; j++){
                if(word.charAt(i) == mom[j]){
                    index = j;
                    break;
                }
            }
            if(index == -1){
                answer += word.charAt(i);
            }else answer += son[index];
        }
        return answer;
    }
}
