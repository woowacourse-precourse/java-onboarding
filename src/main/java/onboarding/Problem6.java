package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
		List<String> answer = List.of("answer");
		answer = new ArrayList<String>();	
		String target="";
		String targetTwo="";
		String temp="";
		for(int i=0; i<forms.size(); i++) {			
			target = forms.get(i).get(1); // 제이엠
			if(target.length()>1) {
				for(int j=0; j<target.length()-1; j++) {
					temp="";
					temp += target.charAt(j);
					temp += target.charAt(j+1);
					System.out.println(temp);					
					for(int k=1; k<forms.size()-1; k++) { // 1~3 마지막은 비교할 필요가 없음
						targetTwo=forms.get(k).get(1);
						System.out.println("비교대상: "+targetTwo);	
						if(k==forms.size()-1) System.out.println("끝!");
						if(targetTwo.indexOf(temp)>=0) { // 중복일때							
							String email = forms.get(k).get(0);
							System.out.println("중복된 닉네임 이메일: "+email);
							if(answer.size()==0) { //
								answer.add(email);
								answer.add(forms.get(j).get(0));
							}
							else {
								for(int s=0; s<answer.size(); s++) {									
									if(forms.get(i).get(0).equals(forms.get(s).get(0))) continue;
									System.out.println("s는: "+s);
									System.out.println("비교 이메일: "+answer.get(s)+" / answer Size: "+answer.size());
									System.out.println("현재 이메일: "+email);									
									if(answer.get(s).equals(email)) break;										
									else if(answer.get(s)!=(email) && s==answer.size()-1) {
										answer.add(email);
										System.out.println("추가한 이메일");
										System.out.println("email:"+email+" / answer.get(s):"+answer.get(s));
									}
								}
							}
						}
					}
				}				
			}			
		}	
		Collections.sort(answer);		
		return answer;
    }
}
