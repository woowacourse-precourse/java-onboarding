package onboarding;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * 기능 목록 1) putHash 2) putName 3) overLap 4) check 5) makeAnswer
 * 
 * @version java11 2022년 10월 31일
 * @author 이규호(tlqkrus012345)
 *
 */
public class Problem6 {
	
	static HashMap<String, String> formsMap = new HashMap<>();
	static HashSet<String> setName = new HashSet<>();
	static HashSet<String> setEmail = new HashSet<>();
	static String[] name;
	
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        name = new String[forms.size()];
        
        putHash(forms);
        putName(forms);
        return answer;
    }
    /**
     * HashMap에 key값 이메일 value값 닉네임을 집어넣는 기능이다
     * 
     * @param forms
     */
    public static void putHash(List<List<String>> forms) {
    	for(List<String> list : forms) {
    		formsMap.put(list.get(0), list.get(1));
    		
    	}
    }
    
    /**
     * String배열에 닉네임을 집어넣는 기능이다
     * 
     * @param forms
     */
    public static void putName(List<List<String>> forms) {
    	int i = 0;
    	for(List<String> list : forms) {
    		name[i] = list.get(1);
    	}
    }
}
