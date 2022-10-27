package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }


    /**
     * 공백 = 0 소문자 = 1 대문자 = 2 로 배열을 반환해주는 함수
     */

    static int[] check_alpha(String word) {
        int[] word_array = new int[word.length()];

        for (int i=0;i<word.length();i++) {
            int ascii = word.charAt(i);
            word_array[i] = upper_lower_case(ascii);
        }

        return word_array;
    }

    /**
     * 해당 아스키 넘버가 대문자인지 소문자인지 공백인지
     * 구분해주는 함수
     */

    static int upper_lower_case(int ascii){
        if(ascii>=65 && ascii<=90){
            return 2;
        }

        if(ascii>=97 && ascii<=122){
            return 1;
        }

        return 0;
    }

    /**
     * 반환값을 보고 각각 변환해주는 함수
     */

    /**
     * 실행을 위한 함수
     */

}

