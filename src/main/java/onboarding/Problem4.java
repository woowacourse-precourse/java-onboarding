package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0;i<word.length();i++){
          //  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
          //  26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10  9  8  7  6  5  4  3  2  1
          // 27-b
          char a=word.charAt(i);
            if('a'<=a&&'z'>=a){
                answer+=(char)('{'-(int)a);
            }
            else if('A'<=a&&'Z'>=a){
                answer+=(char)('['-(int)a);
            }
            else{
                answer+=" ";
            }
        }
        return answer;
    }
}
