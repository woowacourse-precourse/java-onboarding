package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.List;

public class Problem6 {
	public static void main(String[] args) {
		List<List<String>> forms= new ArrayList<List<String>>(10000);
		String pattern = "^[a-zA-Z0-9]{1,9}@email\\.com[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{1,19}$";

		String[] arr;
		boolean check = true;
		if(forms.size()>=1 && forms.size()<=10000) {
			for(int i=0;i<forms.size();i++) {
				String str = forms.get(i).get(0).concat(forms.get(i).get(1));
				if(!Pattern.matches(pattern, str)) {
					check=false;
					break;
				}
			}
		}else {
			check=false;
		}
		if(check==true) {
			solution(forms);
		}
		
	}
	
	public static List<String> solution(List<List<String>> forms) {
		String[][] nickname_arr = new String[10000][];
		List<String> answer=new ArrayList<>();

		for(int m =0;m<forms.size();m++) {
			String nickname = forms.get(m).get(1);
			nickname_arr[m]=new String[nickname.length()-1];   //nickname_arr[0] 제이,이엠 저장 , nickname_arr[1] 엠제,제이 저장
			for(int j=0;j<nickname.length()-1;j++) {
				if(j==nickname.length()-2) {
					nickname_arr[m][j]=nickname.substring(j);
				}else {
					nickname_arr[m][j]=nickname.substring(j,j+2);
				}
			}
		}	
		
		for(int i=0;i<forms.size();i++) {
			String nickname = forms.get(i).get(1);
			inner : for(int j=0;j<forms.size();j++) {
				for(int k=0;k<forms.get(j).get(1).length()-1;k++)
				{
					if(forms.get(j).get(1).equals(nickname))
						break;
					if(nickname.contains(nickname_arr[j][k])) {
						answer.add(forms.get(i).get(0));
						break inner;
					}
				}			
			}		
		}
		HashSet <String> set = new HashSet<>(answer);
		answer = new ArrayList<String>(set);
		String[] result = answer.toArray(new String[answer.size()]);
		Arrays.sort(result);
		answer = new ArrayList<>(Arrays.asList(result));
		return answer;
	}
}
