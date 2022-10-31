package onboarding;

public class Problem4 {
    public static String solution(String word) {

        String answer = "";

        for(int i = 0; i < word.length() ; i++){

            answer += specialSeparate(word.charAt(i));

        }

        return answer;
    }

    public static String specialSeparate(char word){

        char answer = 0;

        if(word<65){

            answer = word;

        }

        if((word>=65) && (word<=90) ){

            answer =letterSeparate(word);

        }
        if ((word>90) &&(word<97)){

            answer = word;

        }
        if((word>=97) && (word<=122)){

            answer =letterSeparate(word);

        }

        if(word>122){

            answer = word;

        }

        return String.valueOf(answer);

    }
    public static char letterSeparate(char word){

        char answer=0;

        int firstCode = 0;

        if( (word <= 90) && (word>=65)){

            firstCode = 65;

        }

        if((word >=97) &&(word <=122)) {

            firstCode = 97;

        }

        answer = reverse(word, firstCode);


        return answer;
    }
    public static char reverse(int word, int firstCode){

            char answer =0;

            for (int i = 0; i <= 25; i++) {

                if (word == (firstCode + i)) {

                    answer += (char) (firstCode + (25- i));

                    break;

                }
            }

            return answer;

    }
}
