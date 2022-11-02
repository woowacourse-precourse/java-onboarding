package onboarding;

import java.util.ArrayList;
import java.util.List;

import onboarding.problem7.Network;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Network network = new Network(friends, visitors);
		return new ArrayList<>(network.recommendFriendsFor(user));
	}
}
