package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int ascii = c, changeTo;

            if( ascii > 64 && ascii< 91){
                changeTo = 155-ascii;
            } else if(ascii > 96 && ascii < 123){
                changeTo = 219-ascii;
            } else{
                answer.append(c);
                continue;
            }
            String changedWord = String.valueOf((char)changeTo);
            answer.append(changedWord);
        }
        return answer.toString();
    }

    public static void main(String[] args){
        System.out.println(solution("I love you")); // "R olev blf"
        System.out.println(solution("Hello!")); // "Svool!"
    }
}
