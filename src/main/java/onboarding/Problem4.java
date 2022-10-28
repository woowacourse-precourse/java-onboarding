package onboarding;

/*
 * 예외 생각해보기
 */
public class Problem4 {
    public static String solution(String word) {
        for (char a : word.toCharArray()){ // 예외처리 문자열이 아니면
            if((a < (char)'A') && (a > (char)'z' && " ".equals(a))){
                System.out.println("잘못된 입력입니다. word를 다시 주세요 잘못된 문자는 : " + a);;
                continue;
            }
        }
        String answer = "";
        char[] arr = word.toCharArray();

        for(char a : arr){
            answer += change(a);
        }
        return answer;
    }

    public static String change(char alphabet){
        if(Character.isUpperCase(alphabet)){ //대문자면
            alphabet = (char)(('Z' + 'A') - (int)alphabet);
        }else if(Character.isLowerCase(alphabet)){ //소문자면
            alphabet = (char)(('z' + 'a') - (int)alphabet);
        }else if(Character.isWhitespace(alphabet)){ //
            alphabet = ' ';
        }
        System.out.println(String.valueOf(alphabet));
        return String.valueOf(alphabet);
    }
}

