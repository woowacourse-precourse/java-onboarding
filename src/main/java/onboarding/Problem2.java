package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//해결방법
// TODO: 채택 sol1. 스택을 이용한 중복문자 제거
// sol2. 문자열 나누기를 이용한 중복문자 제거
public class Problem2 {
    public static String solution(String cryptogram)  {
        try{
            List<String> stack = new ArrayList<>(Arrays.asList(cryptogram.split("")));
            valid(cryptogram); //입력조건이 형식에 맞는지 확인
            while(!stack.isEmpty()){
                int size = stack.size();
                for(int i = 0; i < stack.size(); i++){ //문자 str1 선택
                    String s1 = stack.get(i);
                    for(int j = i+1; j < stack.size(); j++){    //문자 str2 선택
                        String s2 = stack.get(j);
                        //문자가 일치할때
                        if(s1.equals(s2)){
                            if(j == stack.size()-1){    //끝까지 문자가 같을 때
                                for(int k = i; k <= j; k++){
                                    stack.remove(i);    //i 부터 끝까지 제거
                                }
                            }
                        }else{     //일치하지 않을 때
                            if(i != j-1){   //그동안 일치하다 현재 일치하지 않음
                                for(int k = i; k < j; k++){
                                    stack.remove(i); //i부터 j-1까지 삭제
                                }
                            }
                            break;
                        }
                    }
                }
                if(size == stack.size()){   //아무것도 변경된것이 없으면 while문 탈출
                    break;
                }
            }
            return String.join("", stack);
        }catch(Exception e){
            System.out.println(e);
            return "입력 문자가 조건에 맞지 않습니다.";
        }

    }

    public static void valid(String s) throws Exception {
        if(s.length() <= 0 || s.length() > 1000)
            throw new Exception("문자열의 길이가 조건에 맞지 않습니다. size:" + s.length());
        for(int i = 0; i < s.length(); i++){
            Character c= s.charAt(i);
            if(c.isUpperCase(c)) throw new Exception("입력값이 소문자가 아닙니다. 소문자로 변경해주세요: "+s);
        }
    }
}
