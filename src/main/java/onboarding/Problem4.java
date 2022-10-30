package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        //String[] letter = word.split("");

        for(int i = 0; i < word.length() ; i++){
           if(word.charAt(i)<65){
               answer.append(word.charAt(i));
               continue;
           }
           if(word.charAt(i)>=65 && word.charAt(i)<=97 ){
               answer.append(reverse(word.charAt(i)));
               continue;
           }
           if (word.charAt(i)<97){
               answer.append(word.charAt(i));
               continue;
           }
           if(word.charAt(i)<=122){
               answer.append(reverse(word.charAt(i)));
               continue;
           }
           if(word.charAt(i)>122){
               answer.append(word.charAt(i));
           }



        }

        return answer.toString();
    }
    public static char reverse(char word){
        char answer = 0;
        if( word <= 90 && word>=65){
            for(int i = 0; i<=25 ; i++){
                if (word == (65+i) ){
                    answer += (char)(65+(25-i));
                    break;
                }
            }
        }
        else if(word >=97 &&word <=122) {
            for (int i = 0; i <= 25; i++) {
                if (word == (97 + i)) {
                    answer += (char) (97 + (25- i));
                    break;
                }
            }
        }

        return answer;
    }
}
