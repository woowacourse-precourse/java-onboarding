package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        int wordLength = word.length();

        if (wordLength<1 || wordLength >1000){
            System.out.println("Please, Enter between 1 ~ 1000 words length");
            return word;
        }


        while (wordLength > 0 ) {
            char character = word.charAt(wordLength-1); // character를 하나씩 뽑아오기
            int numASCII = character; // 뽑아온 character를 아스키 코드로 바꾸기


            if (numASCII >= 65|| numASCII <= 90 ){ //아스키 코드로 (대문자)알파벳인지 확인

                int changeNumASCII = 155 - numASCII;

                char changeCharacter = (char) changeNumASCII;

                answer = changeCharacter + answer;


            } else if (numASCII >= 97 || numASCII <= 122) { //아스키 코드로 (소문자)알파벳인지 확인

                int changeNumASCII = 219 - numASCII;

                char changeCharacter = (char) changeNumASCII;

                answer = changeCharacter + answer;

            } else if (numASCII < 65 || numASCII > 90 || numASCII < 97 || numASCII > 122){ //아스키 코드로 나머지 문자인지 확인

                char changeCharacter = (char) numASCII;

                answer = changeCharacter + answer;

            }

            wordLength -= 1;

        }






        return answer;
    }
}
