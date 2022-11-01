package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
	// key 2글자 value 몇번 나왔는지
	static HashMap<String, Integer> hm;
	
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        
        hm = new HashMap<>();
        
        // 리스트에 있는 닉네임을 전부 다 두글자씩 잘라서 맵에 넣어줌
        for(int i = 0, size = forms.size(); i < size; i++) {
        	if(isException(forms.get(i))) {
        		continue;
        	}
        	putIntoMap(forms.get(i).get(1));
        }
        
        TreeSet<String> ts = new TreeSet<>();
        for(int i = 0, size = forms.size(); i < size; i++) {
        	if(isException(forms.get(i))) {
        		continue;
        	}
        	if(isDup(forms.get(i).get(1))) {
        		ts.add(forms.get(i).get(0));
        	}
        }
        
        
        String[] arr = new String[ts.size()];
        
        for(int i = 0, len = ts.size(); i < len; i++) {
        	arr[i] = ts.pollFirst();
        }
        
        answer = List.of(arr);
        
        
        return answer;
    }
    
    // Map에 넣기
    static void putIntoMap(String nickName) {
    	
    	for(int i = 1, len = nickName.length(); i < len ; i++) {
    		StringBuilder sb = new StringBuilder();
    		sb.append(nickName.charAt(i-1));
    		sb.append(nickName.charAt(i));
    		String twoChar = sb.toString();
    		hm.put(twoChar, hm.getOrDefault(twoChar, 0)+1);
    	}
    	
    }
    
    // 중복되는거 있는지 확인 두글자 key를 맵에 넣고 값이 2이상이면 true 반환
    static boolean isDup(String nickName) {
    	
    	for(int i = 1, len = nickName.length(); i < len ; i++) {
    		StringBuilder sb = new StringBuilder();
    		sb.append(nickName.charAt(i-1));
    		sb.append(nickName.charAt(i));
    		String twoChar = sb.toString();
    		if(hm.get(twoChar)>1) {
    			return true;
    		}
    	}
    	return false;
    }
    
    static boolean isException(List<String> forms) {
    	String email = forms.get(0);
    	String nickName = forms.get(1);
    	
    	// 이메일 11자 이상 20자 미만
    	int elen = email.length();
    	if(!(elen >= 11 && elen < 20)) {
    		return true;
    	}
    	// 닉네임 1자 이상 20자 미만
    	int nlen = nickName.length();
    	if(!(elen >= 1 && elen < 20)) {
    		return true;
    	}
    	
    	// 이메일 @ 뒤에 도메인 email.com인지 확인
    	int idxa = email.indexOf("@");
    	StringBuilder sb = new StringBuilder();
    	for(int i = idxa+1, len = email.length(); i < len; i++) {
    		sb.append(email.charAt(i));
    	}
    	String str = sb.toString();
    	if(!(str.equals("email.com"))) {
    		return true;
    	}
    	
    	// 닉네임 전부 한글인지
    	for(int i = 0; i < nlen; i++) {
    		if(Character.getType(nickName.charAt(i))!=5) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
}
