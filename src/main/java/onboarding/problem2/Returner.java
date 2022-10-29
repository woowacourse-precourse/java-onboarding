package onboarding.problem2;

import java.util.Iterator;
import java.util.LinkedList;

public class Returner {

    public static Iterator<String> returnLinkedList(LinkedList<String> argument) {

        return (Iterator<String>) argument.iterator();
    }
}
