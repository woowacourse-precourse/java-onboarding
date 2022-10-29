package onboarding;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] ch = cryptogram.toCharArray();
// check2 검증 하자
        if(!LengthCheck(ch)){
            throw new IllegalArgumentException("1글자 이상 1000글자 이하로 입력 해주세요.");
        }
        return RecursionCode(cryptogram);
    }

    public static String RecursionCode(String cyptogram){
        char[] ch = cyptogram.toCharArray();
        if(DuplicateCheck(ch)){
            Stack<Character> decodeStack = PwDecoder(ch);
            String answer = StackToString(decodeStack);
            return RecursionCode(answer);
        }
        return cyptogram;
    }
    public static boolean DuplicateCheck(char[] num){                                  // 중복 있는지 없는지 체크
        for(int i =0; i<num.length -1; i++){
            if(num[i] == num[i+1]){
                return true;
            }
        }
        return false;
    }
    public static boolean LengthCheck(char[] num){                                  //길이 1이상 1000이하
        if(num.length >=1 &&num.length <= 1000){
            return true;
        }else{
            return false;
        }
    }
    public static Stack<Character> PwDecoder(char[] nu) {
        char decode = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : nu) {

            if (decode != c) {
                stack.push(c);
                decode = c;
            } else if (decode == stack.peek() ) {                      //stack.peek()  제일 상단에 있는 값을 빼지 않고 반환
                stack.pop();
            }
        }
        return stack;
    }
    public static String StackToString(Stack<Character> stack){
        StringBuilder stringBuilder = new StringBuilder();

        for ( char c : stack){
            stringBuilder.append(c);

        }
        return stringBuilder.toString();
    }




}
