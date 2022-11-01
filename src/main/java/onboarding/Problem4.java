package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        int wordLength = word.length();

        //예외사항 : 단어의 길이가 1~1000 사이가 아닌 경우
        if (wordLength<1 || wordLength >1000){
            System.out.println("Please, Enter between 1 ~ 1000 words length");
            return word + "error"; //return error
        }


        while (wordLength > 0 ) {
            char character = word.charAt(wordLength-1); // character를 하나씩 뽑아오기
            int numASCII = character; // 뽑아온 character를 아스키 코드로 바꾸기


            if (numASCII >= 65 && numASCII <= 90 ){ //아스키 코드로 (대문자)알파벳인지 확인

                int changeNumASCII = 155 - numASCII; //대문자 A와 Z의 아스키 코드 합이 155임을 이용. B~Y까지도 마찬가지

                char changeCharacter = (char) changeNumASCII; //바꾼 아스키 코드를 Character로 변환

                answer = changeCharacter + answer;


            } else if (numASCII >= 97 && numASCII <= 122) { //아스키 코드로 (소문자)알파벳인지 확인

                int changeNumASCII = 219 - numASCII; //소문자 a와 z의 아스키 코드 합이 219임을 이용. b~y까지도 마찬가지

                char changeCharacter = (char) changeNumASCII; //바꾼 아스키 코드를 Character로 변환

                answer = changeCharacter + answer;

            } else if (numASCII < 65  || numASCII > 122 || (numASCII > 90 && numASCII < 97)){ //아스키 코드로 알파벳이 아닌 나머지 문자인지 확인

                char changeCharacter = (char) numASCII;

                answer = changeCharacter + answer;

            }

            wordLength -= 1;

        }






        return answer;
    }
}
