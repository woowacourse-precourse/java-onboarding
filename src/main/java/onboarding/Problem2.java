package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//해결방법
// TODO: 채택 sol1. 스택을 이용한 중복문자 제거
// sol2. 문자열 나누기를 이용한 중복문자 제거
public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> stack = new ArrayList<>(Arrays.asList(cryptogram.split("")));

        while(!stack.isEmpty()){
            int size = stack.size();
            for(int i = 0; i < stack.size(); i++){ //문자 str1 선택
                String s1 = stack.get(i);
                for(int j = i+1; j < stack.size(); j++){    //문자 str2 선택
                    String s2 = stack.get(j);
                    //문자가 일치할때
                    if(s1.equals(s2)){
                        if(j == stack.size()-1){    //끝일 때도 불구하고 일치한다면 문자열의 끝index까지 제거 해줘야한다.
                            for(int k = i; k <= j; k++){
                                stack.remove(i);
                            }
                        }
                    }else{     //일치하지 않을 때
                        if(i != j-1){
                            for(int k = i; k < j; k++){
                                stack.remove(i);
                            }
                        }
                        break;
                    }
                }
            }
            if(size == stack.size()){
                break;
            }
        }
        return String.join("", stack);
    }

    public static void main(String[] args) {
        System.out.println(solution("zyelleyz"));
    }
}
