package onboarding;

import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person> {

    public String name;
    public int point;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public void addOnePoint() {
        this.point += 1;
    }

    public void addTenPoint() {
        this.point += 10;
    }

    public String getNameAsString() {
        return this.name;
    }

    public Integer getPointAsInteger() {
        return this.point;
    }

    @Override
    public int compareTo(Person p) {
        if (getPointAsInteger() < p.getPointAsInteger()) {
            return 1;
        } else if (getPointAsInteger() < p.getPointAsInteger()) {
            return -1;
        } else {
            int compareString = getNameAsString().compareTo(p.getNameAsString());
            if (compareString == 1) {
                return 1;
            } else if (compareString == -1) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "name : " + name + "point : " + point;
    }

    @Override
    public boolean equals(Object a) {
        Person obj = (Person) a;
        return (obj.getNameAsString() == this.getNameAsString());
    }

}
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
