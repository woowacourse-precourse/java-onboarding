package onboarding;

/*
 * 예외 생각해보기
 */
public class Problem4 {
    public static String solution(String word) {

        StringBuilder answer = new StringBuilder();
        char[] arr = word.toCharArray();
        for (char alphabet : arr){
            if((Character.isAlphabetic(alphabet))){
                answer.append(change(alphabet));
            }else{
                answer.append(alphabet);
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


