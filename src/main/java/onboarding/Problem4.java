package onboarding;

public class Problem4 {

    static String frog(String word){
        StringBuilder rev_w = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            if((int)word.charAt(i) >=65 && (int)word.charAt(i) <= 90){  // 대문자
                rev_w.append((char) (155 - (int) word.charAt(i)));
            }
            else if((int)word.charAt(i) >=97 && (int)word.charAt(i) <= 122){  // 소문자
                rev_w.append((char) (219 - (int) word.charAt(i)));
            }
            else{
                rev_w.append(word.charAt(i));
            }
        }
        return rev_w.toString();
    }

    public static String solution(String word){
        return frog(word);
    }
}
