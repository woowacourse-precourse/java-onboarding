package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.TreeMap;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;


class Mto
{
	int		val;
	String	key;
	
	public Mto(String key, int val)
	{
		this.key	= key;
		this.val	= val;
	}
	
	public int getVal()
	{
		return val;
	}
	
	public void setVal(int val)
	{
		this.val = val;
	}
	
	public String getKey()
	{
		return this.key;
	}
	
	public void setKey(String key)
	{
		this.key = key;
	}
}


public class Problem7{
	
	//friends에서 user와 친구인 친구 리스트를 얻는다.
	public static List<String> getFriendList(String user, List<List<String>> friends)
	{
		
		ArrayList<String> friend_list = new ArrayList<String>();
		
		//get(0), get(1)로 한 이유는 [user : friend], [friend:user]일 경우를 대비
		for(int i = 0; i < friends.size(); i++)
		{
			if (friends.get(i).get(0).equals(user) == true)
				friend_list.add(friends.get(i).get(1));
			if (friends.get(i).get(1).equals(user) == true)
				friend_list.add(friends.get(i).get(0));
		}
		return friend_list;
	}
	
	//user의 친구들의 친구리스트를 얻는다.
	public static List<String> getFriendOfFriendList(List<String> friend_list, List<List<String>> friends)
	{
		ArrayList<String> friend_of_friend_list = new ArrayList<String>();
		
		//get(0), get(1)로 한 이유는 [user : friend], [friend : user]일 경우를 대비
		for(int i = 0; i < friends.size(); i++)
		{
			for (String iter : friend_list)
			{
				List<String> tmp_friend = friends.get(i);
				if (tmp_friend.get(0).equals(iter) == true)
					friend_of_friend_list.add(tmp_friend.get(1));
				else
					if (tmp_friend.get(1).equals(iter) == true)
						friend_of_friend_list.add(tmp_friend.get(0));
			}
		}
		
		return friend_of_friend_list;
	}
	
	
	public static HashMap<String, Integer> getCalcScore(List<String> friend_of_friend_list, List<String> visitors)
	{
		HashMap<String, Integer> score_table = new HashMap<>();
		
		//친구 점수
		for(String iter : friend_of_friend_list)
		{
			if (score_table.containsKey(iter) == true)
			{
				int	bak_value = score_table.get(iter);
				score_table.put(iter, bak_value + 10);
				continue;//써도 되나?
			}
			score_table.put(iter, 10);
		}
		
		//방문 점수
		for(String iter : visitors)
		{
			if (score_table.containsKey(iter) == true)
			{
				int bak_value = score_table.get(iter);
				score_table.put(iter, bak_value + 1);
				continue;
			}
			score_table.put(iter, 1);
			
		}
		
		return score_table;
	}
	
	public static List<String> sortTable(Map<String, Integer> score_table)
	{
		List<Mto>mto_list = new ArrayList<Mto>();
		
		for(String key : score_table.keySet())
		{
			int	val	= score_table.get(key);
			Mto	mto = new Mto(key, val);
			
			mto_list.add(mto);
		}
		
		Comparator<Integer> reverse_comparator = Comparator.reverseOrder();
		Map<Integer, List<Mto>> map = new TreeMap<>(reverse_comparator);
		
		for (Mto m : mto_list)
		{
			int	key = m.getVal();
			
			if (map.containsKey(key))
			{
				List<Mto> list = map.get(key);
				list.add(m);
			}
			else
			{
				List<Mto> list = new ArrayList<>();
				list.add(m);
				map.put(key, list);
			}
		}

		List<Mto> result_list = new ArrayList<>();
		
		Iterator<Integer> iterators = map.keySet().iterator();
		
		while (iterators.hasNext() == true) {
			List<Mto> tmpList = map.get(iterators.next());
			
			Collections.sort(tmpList, new Comparator<Mto>() {
                @Override
                public int compare(Mto o1, Mto o2) {
                    return o1.getKey().compareToIgnoreCase(o2.getKey());
                }
            });
			result_list.addAll(tmpList);
		}
		
		ArrayList<String> recommend_list = new ArrayList<>();
		
		for (Mto iter : result_list)
			if (iter.getVal() > 0)
				recommend_list.add(iter.getKey());
		
		
		return recommend_list;
	}
	
	
	
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    			/*
    			 * user의 친구 리스트를 얻어오고
    			 * 중복을 제거한다.
    			 */
    			List<String> friend_list = getFriendList(user, friends);
    			friend_list = friend_list.stream().distinct().collect(Collectors.toList());
    			
    			//user의 친구의 친구리스트를 얻어옴
    			List<String> friend_of_friend_list = getFriendOfFriendList(friend_list, friends);
    			
    			//user를 목록에서 삭제
    			friend_of_friend_list.removeIf(item -> item.equals(user));
    			
    			//유저의 친구의 친구가 내 친구라면 삭제
    			List<String> tmp_visitors = new ArrayList<String>(visitors);
    			for (String iter : friend_list)
    			{
    				friend_of_friend_list.removeIf(item -> item.equals(iter));
    				tmp_visitors.removeIf(item -> item.equals(iter));
    			}

    			//채점된 점수와 친구 리스트를 넣는다.
    			Map<String, Integer> score_table = getCalcScore(friend_of_friend_list, tmp_visitors);
    			
    			//점수별 정렬 후 같은 점수끼리 이름별 정렬을 실행한다.
    			List<String> recommend_list = sortTable(score_table);
    			
    			//점수로 정렬 후 hasnext로 다음이 있는지 검사 후 next로 점수가 바뀌는 시점에 새로운 map에 집어넣기 종료 후 같은 점수끼리 모은 map을 key로 다시 정렬 후 출
    			if (recommend_list.size() > 5)
    				recommend_list = recommend_list.subList(0, 5);
    			
    			return recommend_list;
    }

    	
    
}