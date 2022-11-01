package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        int i,j;
        char[] capital = new char[26];
        char[] small = new char[26];
        char[] change_capital = new char[26];
        char[] change_small = new char[26];
        String temp = "";
        for(i=0;i< capital.length;i++){
            capital[i] = (char) (65+i);
            change_capital[capital.length-i-1] = capital[i];
        }
        for(i=0;i< small.length;i++){
            small[i] = (char) (97+i);
            change_small[capital.length-i-1] = small[i];
        }

        for(i =0; i<word.length();i++){
            if(word.charAt(i) == (char)32)
                temp += (char)32;
            for(j =0; j< capital.length;j++){
                if(word.charAt(i) == capital[j])
                    temp += change_capital[j];
                if(word.charAt(i) == small[j])
                    temp += change_small[j];
            }
        }
        answer = temp;
        return answer;
    }
    public static void main(String[] args) {
        String word = "I love you";
        System.out.println(word);
        String answer;
        answer = solution(word);
        System.out.println(answer);
    }
}
