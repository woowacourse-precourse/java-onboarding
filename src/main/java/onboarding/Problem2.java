package onboarding;

import java.util.Deque;
import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        
        // 뒤로 오는거에서 처리해주고
        // 처리 다하면 앞에서부터 출력해야하니까 덱 사용
        Deque<Character> cDeque = new LinkedList();
        
        int len = cryptogram.length();
        
        for(int i = 0; i < len; i++) {
        	char cur = cryptogram.charAt(i);
        	
        	// cDeque에 들어간 맨 뒷부분이 cur과 같지 않으면 cDeque Last에 넣어줌
        	if(cDeque.size()==0 || cDeque.peekLast()!=cur) {
        		cDeque.addLast(cur);
        	  // 만약에 같다면 삭제를 해줘야 됨
        	} else if(cDeque.peekLast()==cur) {
        		// 현재 Deque의 끝부분(pollLast)하고 cur(cDeque에 안넣으면 됨)은 당연히 지워져야하고
        		cDeque.pollLast();
        		// 뒤에 붙는 같은 알파벳들도 삭제해줘야됨(확인하고 그만큼 i 건너뛰기)
        		int nextidx = -1;
        		for(int j = i+1; j < len; j++) {
        			char nextchar = cryptogram.charAt(j);
        			if(cur != nextchar) {
        				nextidx = j;
        				break;
        			}
        		}
        		// 끝까지 같은경우에는 -1로 끝남
        		if(nextidx==-1) {
        			// 그냥 break 해주면 됨
        			break;
        		}
        		// 위에서 ++ 해주니까
        		i = nextidx-1;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        while(cDeque.size()>0) {
        	sb.append(cDeque.pollFirst());
        }
        answer = sb.toString();
        
        return answer;
    }
}
