package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        int initLength = cryptogram.length();
        String newCryptogram = removeDuplication(cryptogram);

        while (initLength != newCryptogram.length()){

            System.out.println(newCryptogram);
            initLength = newCryptogram.length();
            newCryptogram = removeDuplication(newCryptogram);
        }

        answer = newCryptogram;
        return answer;
    }

    public static String removeDuplication(String cryptogram){
        String result = "";
        char prev = ' ';

        boolean check = false;

        int idx = 0;
        while(idx < cryptogram.length()){

            if(prev != cryptogram.charAt(idx)){
//                System.out.println("prev = " + prev + ", curr = " + cryptogram.charAt(idx));
                result += String.valueOf(prev);
                prev = cryptogram.charAt(idx);

            }else{
//                System.out.println("prev = " + prev + ", curr = " + cryptogram.charAt(idx));

                idx++;
                System.out.println(idx);
                if(idx < cryptogram.length()) {

                    prev = cryptogram.charAt(idx);
                }else{

                    check = true;
                }
            }
            idx++;
        }

        if(!check) {
            result += String.valueOf(prev);
        }
        return result.substring(1);
    }
    public static void main(String[] args) {
//        System.out.println(solution("browoanoommnaon"));
        System.out.println(solution("zyelleyz"));
    }
}
