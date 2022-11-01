package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        
        
        // 연속된 글자가 겹치면 key를 반환
        HashSet<String> set = new HashSet<>();
        HashMap<String, String> map = new HashMap<>();
        
        // form에 담긴 정보의 개수만큼 for문을 돌린다.
        for(int i=0; i<forms.size()-1; i++){
        	// 검사에 사용할 이름을 뽑는다.
            String name = forms.get(i).get(1);
            
            // 이름의 글자가 한글자면 검사에서 제외한다.
            if(name.length() == 1){
                break;
            }
            
            // 이름의 길이만큼 for문을 돌리면서 다른이름과 비교한다.
            for(int j=0; j<name.length()-1; j++){
            	// 이름 비교 대상(2개씩)
                String check = name.substring(j, j+2);
                
                // 만약 이 이름을 초함하고 있다면
                if(map.containsKey(check)){
                	// 해당 이름을 포함하고 있는 이메일을 꺼내 담는다.
                    String email = map.get(check);
                    
                    // 비교대상의 정보가 아니라면 담는다.
                    if(!email.equals(forms.get(i).get(0))){
                        set.add(email);
                        set.add(forms.get(i).get(0));
                    }
                }
                
                map.put(check, forms.get(i).get(0));
            }
        }

        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
    	List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
    	
    	System.out.println(solution(forms));
	}
}
