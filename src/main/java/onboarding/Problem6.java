package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	int f_size = forms.size();
		List<String> answer = new ArrayList<>(Arrays.asList());
		
		List<String> mail = new ArrayList<>(Arrays.asList());  // �̸��ϸ� ����Ʈ�� ����
		List<String> name = new ArrayList<>(Arrays.asList());  // �̸��� ����Ʈ�� ����
		
		for(int i = 0; i<f_size; i++) {
			List<String> email = forms.get(i);
			mail.add(email.get(0));
			name.add(email.get(1));
		}
		//System.out.println(mail);
		//System.out.println(name);
		
		for(int i = 0; i<f_size; i++) {
			String n = name.get(i);  // �̸� �ϳ��� n ������ ����
			for(int j = 0; j<n.length()-1; j++) {
				String overlap = n.substring(j, j+2); // �̸� �� ���ھ� �����̽�
				
				// �� ���ڿ� �ȿ� overlap�� �ߺ��Ǵ� ���ڿ��� �ִ��� ã��
				for(int o = name.indexOf(n)+1; o < f_size; o++) {
					// �ߺ� ���ڿ��� �߰ߵǸ�,,,
					if(name.get(o).contains(overlap)) {
						
						if(!answer.contains(mail.get(i))) { answer.add(mail.get(i)); }
						if(!answer.contains(mail.get(o))) { answer.add(mail.get(o)); }
					}
				}
			}
		}
		
		Collections.sort(answer);
		return answer;
    }
}
