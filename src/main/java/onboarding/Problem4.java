package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = process(word);
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

    static String frog_alpha_change(int[] word_array, String word,int idx) {

        String change ="";

        String[] upper = {"Z","Y","X","W","V","U","T","S","R"
                ,"Q","P","O","N","M","L","K","J","I","H","G","F",
                "E","D","C","B","A"};

        String[] lower = {"z","y","x","w","v","u","t","s"
                ,"r","q","p","o","n","m","l","k","j","i","h","g",
                "f","e","d","c","b","a"};

        if(word_array[idx] == 2){
            change = upper[word.charAt(idx)-'A'];
        }

        if(word_array[idx] == 1) {
            change = lower[word.charAt(idx)-'a'];
        }

        if(word_array[idx] == 0){
            change = " ";
        }

        return change;

    }
    /**
     * 실행을 위한 함수
     */

    static String process(String word) {

        int n = word.length();
        int[] check_alphabet = check_alpha(word);


        String ans = "";

        for (int i=0;i<n;i++) {
            ans += frog_alpha_change(check_alphabet,word,i);
        }

        return ans;

    }

}

