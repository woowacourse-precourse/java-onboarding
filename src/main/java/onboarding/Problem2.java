package onboarding;
import java.util.Stack;

public class Problem2 {
    public static Stack<Character> scan(char[] arr){
        Stack<Character> stack= new Stack<>();
        for( int i =0;i<arr.length;i++){
            if(stack.size()==0){ //사이즈가 0인경우 터지므로 0일때는 그냥 넣기
                stack.push(arr[i]);
            }
            else if(stack.peek()==arr[i]){ //스택맨위의 값과 현재값이 같다면 삽입없이 맨위의값 pop
                stack.pop();
            }
            else{ //전부 아니라면 삽입
                stack.push(arr[i]);
            }
        }
        return stack;
    }
    public static String solution(String cryptogram) {

        char[] arr=cryptogram.toCharArray();
        Stack<Character> temp=scan(arr);
        String answer = "";
        for (int i =0;i<temp.size();i++){ //스택에 있는 값 string으로 변환
            answer+=temp.get(i);
        }
        return answer;
    }
}
