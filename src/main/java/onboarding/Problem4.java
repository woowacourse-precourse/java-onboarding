package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder larr = new StringBuilder("abcdefghijklmnopqrstuvwxyz").reverse();
        StringBuilder uarr = new StringBuilder("abcdefghijklmnopqrstuvwxyz".toUpperCase()).reverse();
        for(int i = 0; i < word.length(); i++){
            //System.out.println(word.charAt(i));
            if(!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z') && !(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')){
                answer += word.charAt(i);
                continue;
            }
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){//대문자인경우
                char cur = uarr.charAt((int)(word.charAt(i)-'A'));
                //System.out.println(word.charAt(i) + " " + cur);
                answer += cur;
                continue;
            }
            char cur = larr.charAt((int)(word.charAt(i)-'a'));
            //System.out.println(word.charAt(i) + " " + cur);
            answer += cur;
        }
        return answer;
    }
}
