package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// ģ���� ģ�� -> 10��
// Ÿ�� ���� �湮 -> 1��
// friends �� [ID_1, ID_2]�̸� ���� ģ����� �ǹ�
// ���̵�� ��� ���ĺ� �ҹ���
// ��õ�� ģ���� ������ ����

// ģ�� ��õ ������ ���� 5�� 1.������ -> 2.�̸��� ���� �����Ͽ� ����� ����

//1.ģ�����踦 map���� ���� -> id-[ģ����..]
//2.���� �ָ��ϴ� ����� user�� ģ������� ��ȸ�ϸ� ģ���� ģ������ ã�� ������ �߰�����
//2-1.ģ������ map���� user�� ����� �̹� ģ���� ����鵵 ��ĥ �� �ִ�.
//3.visitors �� ��ȸ�ϸ� ������ �߰����ش�.
//4.2-1�ذ�
//5.5������ �߷��� ������ ����


public class Problem7 {
	
	public static HashMap<String, Integer> trim(String user, HashMap<String, List<String>> friends_info, HashMap<String, Integer> points) {
		// user �ڱ��ڽŰ� �̹� ģ���� id�� points���� ����
		HashMap<String, Integer> trimed_points = points;
		List<String> temp = friends_info.get(user);
		temp.add(user);
		for (String f: temp) {
        	trimed_points.remove(f);
        }
		return trimed_points;
	}
	
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    	List<String> answer = new ArrayList<String>();
        
        HashMap<String, List<String>> friends_info = new HashMap<String, List<String>>();
        HashMap<String, Integer> points = new HashMap<String, Integer>(); // ģ�� ��õ ���� ��Ͽ�
        
        // ��� ģ�����踦 ���� -> ����id - [ģ����]
        for (List<String> data: friends) { 
        	String id_1 = data.get(0); // ID_1
        	String id_2 = data.get(1);// ID_2
        	
        	if (!friends_info.containsKey(id_1)) { // id_1 �̶�� Ű���� ������ �󸮽�Ʈ�� �����ؼ� ��������
        		friends_info.put(id_1, new ArrayList<String>());
        	}
        	friends_info.get(id_1).add(id_2); // id_1�� ģ���� id_2 �߰�
        	
        	//id_2���� id_1�� ģ����°� ����
        	if (!friends_info.containsKey(id_2)) {
        		friends_info.put(id_2, new ArrayList<String>());
        	}
        	friends_info.get(id_2).add(id_1);
        	
        }
        // �ƴ� ģ���� �������� ���� �߰� ó��
        if (friends_info.containsKey(user)) { // user�� ģ���� �ϳ��� ���� ��츦 ����
        	for (String f: friends_info.get(user)) { // ������ ģ������ ��ȸ
        		
        		for (String f_f :friends_info.get(f)) {// ģ���� ģ�� = f_f�� Ȯ���ϸ� ÷���� ������
        			if (!points.containsKey(f_f)) {
        				points.put(f_f, 0);
                	}
        			points.put(f_f, points.get(f_f) + 10);
        			
        		}
        	}
        }
        //visitors�� ���� �߰� ó��
        for (String visitor: visitors) { // points�� ������ �߰����ش�
        	if (!points.containsKey(visitor)) {
				points.put(visitor, 0);
        	}
			points.put(visitor, points.get(visitor) + 1);
        }
        
        // ������ ���� points���� user �ڱ��ڽ�, �̹� ģ���� ������� ���ԵǱ⿡ �̸� ����.
        // ģ���� ģ���� Ȯ���ϴ� �������� �Ź� �ɷ����� �ͺ��� �ۿ��� �ϴ°� �� ���� �� ����.
        
        points = trim(user, friends_info, points);
        
        //���İ��� ������ -> �̸���
        List<Map.Entry<String, Integer>> list = new LinkedList<>(points.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
        	@Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        		//1. value�� ������������
        		if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }
        		//2.���� ������ key�� ������������
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        
        
        for (int i=0;i<list.size();i++) {
        	if (i > 4) {
        		break;
        	}
        	answer.add(list.get(i).getKey());
        }
        
        return answer;
    }
}
