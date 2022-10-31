package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");       
        answer = new ArrayList<String>();
		String targetOne="";
		String targetTwo="";
		String temp="";
		for(int i=0; i<forms.size(); i++) {		
			targetOne = forms.get(i).get(1); 
			if(targetOne.length()>1) {
				for(int j=0; j<targetOne.length()-1; j++) {
					temp="";
					temp += targetOne.charAt(j);
					temp += targetOne.charAt(j+1);
					System.out.println(temp);
					for(int k=1; k<forms.size(); k++) { // 1~4
						targetTwo=forms.get(k).get(1); // 제이슨						
						System.out.println("비교대상: "+targetTwo);						
						if(targetTwo.indexOf(temp)>=0) { // 중복일때 
							String email = forms.get(k).get(0);
							System.out.println(email);
							if(answer.size()==0) {
								System.out.println("첫번째 이메일 추가했음");
								answer.add(email);
							}
							else {
								for(int s=0; s<answer.size(); s++) {
									if(answer.get(s)==email) {
										break;
									}else if(s==answer.size()-1 && answer.get(s)!=email) {
										answer.add(email);
										System.out.println("추가했음!!");
									}
								}
							}
						}
					}
				}				
			}			
		}        
        return answer;
    }
}
