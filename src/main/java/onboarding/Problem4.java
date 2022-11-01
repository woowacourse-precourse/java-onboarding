package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        List<Character> list = new ArrayList<>();
        for(int i = 0; i<word.length();i++) {
        	list.add(word.charAt(i));
        }
        for(int i = 0; i<list.size();i++) {
        	if(list.get(i) >= 97 || list.get(i) <= 122) { //소문자 판별
        		char A = (char)(list.get(i)+9);
        		list.set(i,A);
        	}
        	if(list.get(i) >= 65 || list.get(i) <= 90) { //대문자 판별
        		list.set(i,(char)change(i+'0'));
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch: list) {
            sb.append(ch);
        } 
        String string = sb.toString();
        return answer = string;
    }
    public static char change(char i) { //list.get i 에서 알파벳 들어오면 리버스 해주는 함수
    	char A = i;
    	if(A >= 97 || A <= 122) {
    		A = A-219;
    		if(A < 0) {
    			A = A*-1;
    		}
    	}else if(A >= 65 || A <= 90) {
    		A = A-155;
    		if(A < 0) {
    			A = A*-1;
    		}
    	}
    	char value_char2 = (char)(A +'0');
    	return value_char2;
    }
    public static void main(String[] args) {
    	String word = "I love you";
    	System.out.println(change('b'));
    	/* List<Character> list = new ArrayList<>();
    	 
         for(int i = 0; i<word.length();i++) { //이상 무
         	list.add(word.charAt(i));
         }
         for(int i = 0; i<list.size();i++) {
        	 char A = (char)(list.get(i)+9);//I+9  R나옴
        	 System.out.print(A); 
         }
         for(int i = 0; i<list.size();i++) {
        	 if(list.get(i) >= 97 || list.get(i) <= 122) { //소문자 판별
        		char A = (char)(list.get(i)+change(i));
        		list.set(i,A);
        	}
        	 else if(list.get(i) >= 65 || list.get(i) <= 90) { //대문자 판별
        		 char A = (char)(list.get(i)+change(i));
         		list.set(i,A);
        	}
         }
         StringBuilder sb = new StringBuilder();
         
         for (Character ch: list) {
             sb.append(ch);
         } 
         String string = sb.toString();
         System.out.println(string);*/
         }
}
