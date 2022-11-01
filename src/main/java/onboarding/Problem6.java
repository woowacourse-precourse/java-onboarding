package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        //닉네임, 인덱스값을 저장하는 해쉬맵
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        /*
         * forms.get(0) 이메일, 닉네임 접근
         * forms.get(0).get(0) 이메일 접근
         * forms.get(0).get(1) 닉네임 접근
         * */
        
        
        for(int i=0; i<forms.size(); i++) {
        	
        	//닉네임 불러오기
        	String name = forms.get(i).get(1);
        	
        	//2글자씩 나누고 해쉬맵에 저장
        	for(int n=0; n<name.length()-1; n++) {
        		
        		//이름 2글자로 나누기
        		String twoLetters = name.substring(n, n+2);
        		
        		//해쉬맵에 저장되어있는 2글자이면 중복
        		if(hmap.containsKey(twoLetters)) {
        			//해당 인덱스의 이메일 answer에 저장
        			answer.add(forms.get(i).get(0));
        			//해당 인덱스와 겹치는 해쉬맵에 있는 인덱스의 이메일 answer에 저장
        			answer.add(forms.get(hmap.get(twoLetters)).get(0));
        		}
        		//해쉬맵에 저장되어 있는 2글자가 아니면 저장
        		else {
					hmap.put(twoLetters, i);
				}
        		
        	}
        	
        	
        }
        
        //중복제거
        HashSet<String> set = new HashSet<String>(answer);
        //answer = List.copyOf(set);
        answer = new ArrayList<String>(set);
        //오름차순 정렬
        Collections.sort(answer);
        
        /*
        신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 return
        */
        return answer;
    }
}
