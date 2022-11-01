package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        
        boolean isEnd= false;
        
        while(true) {
        	//0~1글자는 중복제거할 필요가 없으므로 break
        	if(answer.length() <2) {
        		break;
        	}
        	
        	//맨 처음글자 자르기
        	String beforeStr = answer.substring(0, 1);
        	int startIndex =-1;
        	boolean isSame= false;
        	//반복되는 글자를 찾아 제거하는 for문
        	for(int i=1; i<answer.length(); i++) {
        		
        		//현재 글자 자르기
        		String getStr = answer.substring(i, i+1);
        		
        		//이전 글자와 현재 글자가 같을때
        		if(beforeStr.equals(getStr)) {
        			if(isSame ==false) {
        				isSame = true;
        				//같은 글짜 시작 인덱스 저장
        				startIndex = i-1;
        				//같은 글자 반복이 문자열 마지막까지인 경우
        				if(isSame && i+1 == answer.length()) {
        					//맨 처음부터 반복 문자가 아닌 인덱스까지 자르기
            				answer = answer.substring(0, startIndex);
            				//중복을 제거했으므로 for문 빠져나가기
            				break;
            			}
        			}
        			
        			
        		}
        		else {
        			//이전 글자와 현재 글자가 다를 때 isSame이 true 이면 반복이 끝났다는 것
        			if(isSame) {
        				//맨처음부터 반복 문자가 아닌 인덱스까지 자른 문자열 + 반복이 끝난 문자부터 마지막 문자까지 자른 문자열 합치기
        				answer = answer.substring(0, startIndex).concat(answer.substring(i));     
        				//중복을 제거했으므로 for문 빠져나가기
        				break;
        			}
        			//아니라면 현재 글자를 이전 글자로 저장해주고 for문반복하기
					beforeStr = getStr;
				}
        	}
        	//for문 반복이 끝났는데 isSame이 false인 경우 반복되는 문자가 없다는 것
        	if(isSame == false) {
        		//암호해독 완료 true 설정
        		isEnd = true;
        	}
        	//0~1글자는 중복제거할 필요가 없고, isEnd가 true라면 암호해독이 끝
        	if(answer.length() <2 || isEnd ) {
        		//while문 빠져나가기
        		break;
        	}
        }
        
        
        
        
        
        
        
        
        return answer;
    }
}
