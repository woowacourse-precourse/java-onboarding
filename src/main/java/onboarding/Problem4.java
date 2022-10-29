package onboarding;

/*
 * 예외 생각해보기
 */
public class Problem4 {

    public static String solution(String word) {

        StringBuilder answer = new StringBuilder();
        char[] arr = word.toCharArray();
        for (char a : arr){
            if(a >= 'A' && a <='Z' || a >= 'a' && a <= 'z') {
                answer.append(change(a));
            }else{
                answer.append(a);
            }
        }
        return answer.toString();
    }


    public static String change (char alphabet){
        if (Character.isUpperCase(alphabet)) { //대문자면
            alphabet = (char) (('Z' + 'A') - (int) alphabet);
        } else { //소문자면
            alphabet = (char) (('z' + 'a') - (int) alphabet);
        }
        return String.valueOf(alphabet);
    }
}


