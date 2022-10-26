package onboarding;

import onboarding.problem1.PageGamer;
import onboarding.problem1.WrongInputException;

import java.util.List;

/**
 * Problem 01 function list
 * - Check availability of input
 * - Calculate max value of pages
 * - Get winner between person a and b
 */
class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            PageGamer gamer = new PageGamer(pobi, crong, 400);
            return gamer.winner();
        } catch (WrongInputException e) {
            return -1;
        }
    }
}