package onboarding;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String tmp = "";

        int check = 1;
        while (true){
            tmp = "";
            for (int i = 0; i < cryptogram.length()-1; i++){
                String str = cryptogram.substring(i, i+1);
                String strAfter = cryptogram.substring(i+1, i+2);

                if (str.equals(strAfter)){     // 이후 글자와 같으면
                    check = 0;
                } else if (check == 0){
                    check = 1;
                } else {
                    tmp += str;
                    System.out.println("tmp :"+tmp+i);
                }
            }

            if (check == 1 && cryptogram.length() != 0){     // 전 글자와 같고 길이가 0이 아니면
                tmp += cryptogram.substring(cryptogram.length()-1, cryptogram.length());    // 마지막 글자
            }

            if (tmp.equals(cryptogram)){
                break;
            } else{
                cryptogram = tmp;
            }
        }

        answer = cryptogram;

        return answer;
    }


}


/*
package onboarding;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
// browoanoommnaon
        System.out.println(cryptogram);
//        String[] strBase = alphabet.split("");
        String[] strInput = cryptogram.split("");
//        System.out.println(Arrays.toString(strInput));  //체크용

//        for (int i = 0; i<strInput.length; i++){
//            System.out.println("i: "+strInput[i]);
//            System.out.println("i+1: "+strInput[i+1]);
//
//            if (strInput[i].equals(strInput[i+1])){
//
//                result = 1;    // 중복 있음
//                System.out.println("중복있음");
//            }
//        }
        String answerStr[] = strInput;
        String tmp = "";

        System.out.println(check(strInput));
        boolean checking = check(strInput);
        while (checking){
            for (int i = 0; i < answerStr.length; i++){
//                String strI = cryptogram.substring(i, i+1);
//                S
                if (strInput[i].equals(strInput[i+1])){
                    strInput = remove(strInput, i);
                    strInput = remove(strInput, i);
                    answerStr = strInput;
                    System.out.println(Arrays.toString(answerStr));

//                    for (int j = 0; j < answerStr.length; j++){
//                        tmp += answerStr[j];
//                    }
//                    System.out.println("answer 답"+tmp);
                    break;
                }
            }
            System.out.println(Arrays.toString(answerStr));
            checking = check(strInput);
            System.out.println("dddd"+Arrays.toString(answerStr));
//            tmp = "";
//            System.out.println("answer 답"+tmp);

//            System.out.println("체크 :"+checking);
//            System.out.println(Arrays.toString(strInput));
        }

        System.out.println("밖에 나온거"+Arrays.toString(answerStr));
//        System.out.println("체크 :"+checking);
//        System.out.println("answer 답");
//        for (int i = 0; i < answerStr.length; i++){
//            tmp = answer.concat(answerStr[i]);
//            System.out.println("answer 답"+tmp);
//
//        }
        for (int j = 0; j < answerStr.length; j++){
            tmp += answerStr[j];
        }
        System.out.println("answer 답"+tmp);

        answer = tmp;
        System.out.println("answer 답       "+answer);
        return answer;
    }

    private static String[] remove(String[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }

        String[] result = new String[arr.length - 1];

        System.arraycopy(arr, 0, result, 0, index);
        System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);

        return result;
    }

//    private static String[] duplete(String[] arr){
//        for (int i = 0; i<arr.length; i++){
//            if (arr[i] == arr[i+1]){
//                arr = remove(arr, i);
//                arr = remove(arr, i);
//                System.out.println(arr);
//            }
//
//        }
//        return arr;
//    }

    private  static boolean check(String[] arr){
        boolean result = false;
        for (int i = 0; i<arr.length; i++){
            if (arr[i].equals(arr[i+1])){

                result = true;    // 중복 있음
                System.out.println("resutl 안:"+result);
                return result;
            }
//            else{
//                break;
//            }
        }
        System.out.println("false"+result);
        return false;
    }
}

 */