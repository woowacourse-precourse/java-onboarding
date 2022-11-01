package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();
		List<String> myFriend = new ArrayList<>();
		List<List<String>> recommendFriends = new ArrayList<List<String>>();
		List<List<String>> recommendVisitor = new ArrayList<List<String>>();
		if (!restrictions(user, friends, visitors)) {
			myFriend = findMyFriends(user, friends);
			recommendFriends = findRecommendFriends(user, myFriend, friends);
			recommendVisitor = findRecommendVisitor(myFriend, visitors);
			answer = recommend(recommendFriends, recommendVisitor);
		}
		return answer;
	}

	static boolean restrictions(String user, List<List<String>> friends, List<String> visitors) {
		if (!checkingUser(user) || !checkingFriends(friends) || !checkingVisitors(visitors)) {
			return true;
		}
		return false;
	}

	static boolean checkingVisitors(List<String> visitors) {
		if (0 > visitors.size() || 10000 < visitors.size()) {
			return false;
		}
		return true;
	}

	static boolean checkingFriends(List<List<String>> friends) {
		if (1 > friends.size() || 10000 < friends.size()) {
			return false;
		}
		return checkingId(friends);
	}

	static boolean checkingId(List<List<String>> friends) {
		for (int i = 0; i < friends.size(); i++) {
			for (int j = 0; j < 2; j++) {
				int idLen = friends.get(i).get(j).length();
				if (1 > idLen || 30 < idLen) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean checkingUser(String user) {
		if (1 > user.length() || 30 < user.length()) {
			return false;
		}
		return true;
	}

	static List<String> findMyFriends(String user, List<List<String>> friends) {
		List<String> myFriends = new ArrayList<>();
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).get(1).equals(user)) {
				myFriends.add(friends.get(i).get(0));
			}
		}
		return myFriends;
	}

	static List<List<String>> findRecommendFriends(String user, List<String> myFriend,
			List<List<String>> friends) {
		List<List<String>> recommendFriends = new ArrayList<List<String>>();
		List<String> onlyRecommendFriend = new ArrayList<>();
		friends = removeUser(user, friends);
		friends = checkMyFriend(myFriend, friends);
		onlyRecommendFriend = onlyRecommendFriends(friends, 1);
		recommendFriends = recommendScore(onlyRecommendFriend, 10);
		return recommendFriends;
	}

	static List<String> recommend(List<List<String>> recommendFriends, List<List<String>> recommendVisitor) {
		List<String> onlyRecommendFriend = new ArrayList<>();
		List<String> people5 = new ArrayList<>();
		List<List<String>> tmp = new ArrayList<List<String>>();
		tmp.addAll(recommendFriends);
		tmp.addAll(recommendVisitor);
		tmp = sort(tmp);
		onlyRecommendFriend = onlyRecommendFriends(tmp, 0);
		people5 = peaple5Recommend(onlyRecommendFriend);
		return people5;
	}

	static List<String> peaple5Recommend(List<String> people) {
		List<String> people5 = new ArrayList<>();
		int len = 5;
		if (people.size() < 5) {
			len = people.size();
		}
		for (int i = 0; i < len; i++) {
			people5.add(people.get(i));
		}
		return people5;
	}

	static List<List<String>> sort(List<List<String>> tmp) {
		String[][] tmpArr = new String[tmp.size()][2];
		tmpArr = listToArray(tmp);
		for (int i = 0; i < tmpArr.length; i++) {
			tmpArr[i][0] = tmp.get(i).get(0);
			tmpArr[i][1] = tmp.get(i).get(1);
		}
		Arrays.sort(tmpArr, new Comparator<String[]>(){
		    @Override
		    public int compare(final String[] first, final String[] second){
		        return String.valueOf(first[0]).compareTo(
		        		String.valueOf(second[0])
		        );
		    }
		});
		Arrays.sort(tmpArr, new Comparator<String[]>(){
		    @Override
		    public int compare(final String[] first, final String[] second){
		        return Integer.valueOf(second[1]).compareTo(
		        	Integer.valueOf(first[1])
		        );
		    }
		});
		tmp = arrayToList(tmpArr);

		return tmp;
	}

	static List<List<String>> arrayToList(String[][] array) {
		List<List<String>> list = new ArrayList<List<String>>();
		for (int i = 0; i < array.length; i++) {
			if (array[i][0] != null) {
				list.add(Arrays.asList(array[i]));
			}
		}
		return list;
	}

	static String[][] listToArray(List<List<String>> list) {
		String[][] array = new String[list.size()][2];
		for (int i = 0; i < array.length; i++) {
			array[i][0] = list.get(i).get(0);
			array[i][1] = list.get(i).get(1);
		}
		return array;
	}

	static List<List<String>> findRecommendVisitor(List<String> myFriend, List<String> visitors) {
		List<List<String>> recommendVisitors = new ArrayList<List<String>>();
		visitors = removeFriends(myFriend, visitors);
		recommendVisitors = recommendScore(visitors, 1);
		return recommendVisitors;
	}

	static List<List<String>> removeUser(String user, List<List<String>> friends) {
		List<List<String>> tmp = new ArrayList<List<String>>();
		tmp.addAll(friends);
		int userCount = 0;
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).get(1).equals(user)) {
				tmp.remove(i - userCount);
				userCount++;
			}
		}
		return tmp;
	}

	static List<List<String>> checkMyFriend(List<String> myFriend, List<List<String>> friends) {
		List<List<String>> tmp = new ArrayList<List<String>>();
		for (int i = 0; i < myFriend.size(); i++) {
			for (int j = 0; j < friends.size(); j++) {
				if (friends.get(j).get(0).equals(myFriend.get(i))) {
					tmp.add(friends.get(j));
				}
			}
		}
		return tmp;
	}

	static List<String> onlyRecommendFriends(List<List<String>> friends, int saveIndex) {
		List<String> tmp = new ArrayList<>();
		for (int i = 0; i < friends.size(); i++) {
			tmp.add(friends.get(i).get(saveIndex));
		}
		return tmp;
	}

	static List<String> removeFriends(List<String> myFriend, List<String> visitors) {
		List<String> tmp = new ArrayList<>();
		tmp.addAll(visitors);
		tmp.removeAll(myFriend);
		return tmp;
	}

	static List<List<String>> recommendScore(List<String> friend, int score) {
		List<List<String>> recommendScores = new ArrayList<List<String>>();
		List<String> newList = friend.stream().distinct().collect(Collectors.toList());
		List<String> tmp = new ArrayList<>();
		String[][] tmp2 = new String[newList.size()][2];
		int idx = 0;
		tmp.addAll(friend);
		int count = 0;
		for (int i = 0; i < friend.size(); i++) {
			count = Collections.frequency(tmp, tmp.get(0));
			if(count != 0) {
				tmp2[idx][0] = tmp.get(0);
				tmp2[idx][1] = Integer.toString(count * score);
			}
			tmp.removeAll(Arrays.asList(tmp.get(0)));
			i += count - 1;
			idx++;
		}
		recommendScores = arrayToList(tmp2);

		return recommendScores;
	}
	
}
