package onboarding;

/**
 * 1. 같은 문자가 있는지를 확인한다.
 * 2. 있을 시 문자열을 임의 값으로 바꾼다.
 * 3. 문자열로 바꾼 후 임의 값을 제거하여 배열을 생성한다.
 * 4. 이를 반복하여 같은 문자가 없을 때 까지 실행한다.
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        System.out.println(answer);
        String[] strArr = answer.split("");

        while(isDuplication(strArr)){
            for (int i = 0; i <strArr.length - 1; i++) {
                String first = strArr[i];
                String second = strArr[i+1];

                if(isDuplication(first, second)){
                    strArr[i] = "-";
                    strArr[i+1] = "-";
                }
            }
            String str = String.join("",strArr).replace("-","");
            System.out.println(str);
            strArr = str.split("");
        }

        return answer;
    }

    private static boolean isDuplication(String first, String second) {
        if(first.equals(second)){
            return true;
        }
        return false;
    }

    private static boolean isDuplication(String[] strArr) {
        for (int i = 0; i <strArr.length - 1; i++) {
            String first = strArr[i];
            String second = strArr[i+1];

            if(first.equals(second)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solution("browoanoommnaon");
        solution("zyelleyz");
    }
}
