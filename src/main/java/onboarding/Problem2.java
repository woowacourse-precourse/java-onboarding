package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {

        //예외사항 : cryptogram의 길이가 1~1000사이가 아닌 경우
        if (cryptogram.length()>1000 || cryptogram.length()<1){
            System.out.println("Please, enter string length between 1 ~ 1000!");
            return cryptogram + "ERROR"; //return error
        }

        int cryptoWordLength = cryptogram.length(); //cryptogram 단어의 길이 변수

        //예외사항 : cryptogram의 알파벳이 소문자가 아니거나, 알파벳이 아닌 경우
        while (cryptoWordLength > 0 ){

            int numASCII = cryptogram.charAt( cryptoWordLength - 1 );

            if ( numASCII < 97 || numASCII > 122 ) {
                System.out.println("Please, enter small letter !");
                return cryptogram + "ERROR"; //return error
            }
            cryptoWordLength -= 1;
        }


        int checkOverLapActive = 0; //중복된 문자가 없다면 while문을 끝내기 위한 변수, 중복된 문자가 있다면 +1이 커짐, 중복된 문자가 없다면 checkOverLapStatic 값이랑 같아져서 while문이 끝남.
        int checkOverLapStatic = 0; //중복된 문자가 없다면 while문을 끝내기 위한 변수, 중복된 문자가 있다면 while문이 한번 더 돌아가도록 if-break문을 넘어간 후에 +1이 커짐.

        while (checkOverLapStatic == checkOverLapActive) { // checkOverLapActive와 checkOverLapStatic 값 비교를 통해 중복된 문자가 없어질 때까지 While문 진행

            cryptoWordLength = cryptogram.length();


            for (int wordPosition = 0; wordPosition < cryptoWordLength - 1; wordPosition += 1) {

                if (cryptogram.charAt(wordPosition) == cryptogram.charAt(wordPosition + 1)) {

                    if (wordPosition == cryptoWordLength - 2){

                        cryptogram = cryptogram.substring(0, wordPosition); //중복된 단어 제거, 얘의 경우 checkOverLapActive를 변화시켜주지 않는데, 그 이유는 어짜피 맨 뒤가 겹치면 더 이상 겹칠 것이 없기 때문에..

                    } else  if (wordPosition != cryptoWordLength - 2){

                        cryptogram = cryptogram.substring(0, wordPosition) + cryptogram.substring(wordPosition + 2); //중복된 단어 제거

                        checkOverLapActive +=1; // 한번더 while문을 돌려주기 위해

                        break;
                    }
                }
            }

            if (checkOverLapStatic == checkOverLapActive) { //앞서 말한 if-break문으로 이것이 만족되면 더이상 중복체크를 하지 않고 끝낸다.
                break;
            }

            checkOverLapStatic += 1;
        }

        String answer = cryptogram;
        return answer;
    }
}
