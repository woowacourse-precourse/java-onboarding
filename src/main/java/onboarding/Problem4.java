package onboarding;

public class Problem4 {
    public static String solution(String word) {

        String shiftWord="";

        int i;
        for(i=0;i<word.length();i++){

            int ascii = word.charAt(i);  // 문자열을 차례대로 하나 씩 가져와서 아스키코드로 변환


            if(97<=ascii && ascii<=122){    // 입력받은 문자가 소문자 일 때 문자에 매칭되는 다른 문자로 변환해주는 기능
                char c = (char) ((122 + 97) - ascii);
                shiftWord+=c;
            }
            else if(ascii<=90 && 65<=ascii){  // 입력받은 문자가 대문자 일 때 문자에 매칭되는 다른 문자로 변환해주는 기능
                char c = (char) ((65 + 90) - ascii);
                shiftWord+=c;
            }
            else{   // 입력받은 문자가 공백일 때 공백을 변환해주는 기능
                shiftWord+=' ';
            }

        }

        return shiftWord;
    }

    
}
