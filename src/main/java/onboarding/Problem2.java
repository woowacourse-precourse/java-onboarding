package onboarding;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 
 * 기능 목록 1) decipher 2) put 3) check
 * 
 * @version java 11 2022년 10월 30일
 * @author 이규호(tlqkrus012345)
 *
 */
public class Problem2 {
	
	static String answer;
	
    public static String solution(String cryptogram) {
        answer = cryptogram;        
        boolean flag = check(answer);
        
        while(flag) {
        	decipher(answer);
        	flag = check(answer);
        }
        
        return answer;
    }
    /**
     * 
     * 연속된 중복 문자를 제거하는 기능이다
     * 
     * @param s 제거할 문자열을 받는다
     */
    public static void decipher(String s) {
    	Queue<Character> q = new LinkedList<>();
    	String tmp = "";
    	
    	put(q,s);
    	
    	while(!q.isEmpty()) {
    		char c = q.poll();
    		
    		if(q.isEmpty()) {
    			tmp += c;
    		}
    		
    		if(!q.isEmpty() && c != q.peek()) {
    			tmp += c;
    		}
    		
    		if(!q.isEmpty() && c == q.peek()) {
    			q.poll();
    		}
    	}
    	
    	answer = tmp;
    }
    /**
     * 
     * 자료구조 Queue에 문자열을 넣는 기능이다
     * 
     * @param q 문자열 저장 공간
     * @param s 큐에 집어넣을 문자열
     */
    public static void put(Queue<Character> q, String s) {
    	
    }
    /**
     * 
     * @param s
     * @return
     */
    public static boolean check(String s) {
    	return false;
    }
}
