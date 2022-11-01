package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// �г���: �� ���� �̻��� ���ڰ� ���������� ������ �ߺ�
// �̸����� ���̴� 11~19 ��û���� �̸����� email.com ���� ����
// �г����� �ѱ�, 1~19��
// ���� ����� ������������ �����ϰ� �ߺ��� �����ؼ� ����

// �ߺ��Ǵ� �г����� ���� �̸����� ����� ����

//1. 2���ڸ� ���Ƶ� �ߺ����� �����ϴϱ� 2���ھ����� ��� ��츦 ���ϱ�
//2. map�� Ű���� 2���ڵ��� ��� ����� �ϰ� value�� �ش� �ϴ� 2���ڸ� ���� �̸��Ϸ� ����.
//3. ���������� map�� �ݺ��ϸ� value�� 2�� �̻��� ��� �г��ӿ� ���� value ���� set�� ����
//4. set�� ����Ʈ�� ��ȯ�� �����غ���.

//�̸��� ���� ����
//�г����� �� �����̸� ������ �Ȱ��� ����? -> �ߺ����� �����ϰ���



public class Problem6 {
	
	public static boolean length_check(String str, List<Integer> arr) { // �̸��ϰ� �г����� �������ѿ� �´��� Ȯ��
		if(str.length() >= arr.get(0) && str.length() <= arr.get(1)) {
			return true;
		}
		return false;
	}
	
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, List<String>> all_pos = new HashMap<String, List<String>>();
        HashSet<String> filter = new HashSet<>(); // �ߺ� ���ſ� ����
        
        for (List <String> data: forms) {
        	String email = data.get(0);
        	String name = data.get(1);
        	
        	if (!(length_check(email,Arrays.asList(11,19)) && length_check(name, Arrays.asList(1,19)))) { // �������ѿ� ���� ������ ����
        		continue;
        	}
        	
        	if(name.length() == 1) { // ���� �г����� �ѱ��ڶ�� ���� ó��
        		if (!all_pos.containsKey(name)) {
        			all_pos.put(name, new ArrayList<String>());       			
        		}
        		all_pos.get(name).add(email);
        	}
        	for (int i=0; i<name.length() - 1;i++) {
        		String temp = String.valueOf(name.charAt(i)) + String.valueOf(name.charAt(i + 1));
        		if (!all_pos.containsKey(temp)) { // �α��ڰ� �̹� Ű�� ����Ǿ� ���� ������ ���ο� �󸮽�Ʈ ����
        			all_pos.put(temp, new ArrayList<String>()); // �α���-�󸮽�Ʈ ����        			
        		}
        		all_pos.get(temp).add(email); // �󸮽�Ʈ�� �̸��� �߰�
        	}
        }
        
        for(String key: all_pos.keySet()) { // �ߺ��Ǵ� �г����� ���� �̸��ϵ��� ���տ� �־���
        	List<String> email_list = all_pos.get(key);
        	if (email_list.size() > 1) { 
        		filter.addAll(all_pos.get(key));
        	}
        }
        ArrayList<String> answer = new ArrayList<>(filter);
        Collections.sort(answer);
        return answer;
    }
}
