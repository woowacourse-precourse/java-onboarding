package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class Problem6FuncTest {

  @Test
  public void convertFormTest1() {
    List<String> form = new ArrayList<>(Arrays.asList("jm@email.com", "제이엠"));
    List<String> result = new ArrayList<>(Arrays.asList("jm@email.com", "제이", "이엠"));
    assertThat(Problem6.separator.split(form).toString()).isEqualTo(result.toString());
  }

  @Test
  public void convertFormTest2() {
    List<String> form = new ArrayList<>(Arrays.asList("a@email.com", "에이"));
    List<String> result = new ArrayList<>(Arrays.asList("a@email.com", "에이"));
    assertThat(Problem6.separator.split(form).toString()).isEqualTo(result.toString());
  }

  @Test
  public void convertFormTest3() {
    List<String> form = new ArrayList<>(Arrays.asList("z@email.com", "즈"));
    List<String> result = new ArrayList<>(Arrays.asList("z@email.com"));
    assertThat(Problem6.separator.split(form).toString()).isEqualTo(result.toString());
  }

  @Test
  public void convertFormTest4() {
    List<String> form = new ArrayList<>(Arrays.asList("jma@email.com", "제이엠에이"));
    List<String> result = new ArrayList<>(Arrays.asList("jma@email.com", "제이", "이엠", "엠에", "에이"));
    assertThat(Problem6.separator.split(form).toString()).isEqualTo(result.toString());
  }

  @Test
  public void generateIndexMap() {
    List<String> form1 = new ArrayList<>(Arrays.asList("jm@email.com", "제이", "이엠"));
    List<String> form2 = new ArrayList<>(Arrays.asList("jma@email.com", "제이", "이엠", "엠에", "에이"));
    List<List<String>> forms = new ArrayList<>();
    forms.add(form1);
    forms.add(form2);

    Map<String, Set<Integer>> result = Problem6.factory.generateIndexMap(forms);
    String key1 = "제이";
    String key2 = "이엠";
    String key3 = "엠에";
    String key4 = "에이";
    Integer index1 = 0;
    Integer index2 = 1;

    assertThat(result.get(key1)).containsExactly(index1, index2);
    assertThat(result.get(key2)).containsExactly(index1, index2);
    assertThat(result.get(key3)).containsExactly(index2);
    assertThat(result.get(key4)).containsExactly(index2);
  }

  @Test
  public void testCase1() {
    List<List<String>> forms = List.of(
        List.of("jm@email.com", "제이엠"),
        List.of("jason@email.com", "제이슨"),
        List.of("woniee@email.com", "워니"),
        List.of("mj@email.com", "엠제이"),
        List.of("nowm@email.com", "이제엠")
    );
    List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
    assertThat(Problem6.solution(forms)).isEqualTo(result);
  }

  @Test
  public void testCase2() {
    List<List<String>> forms = List.of(
        List.of("jm@email.com", "제이엠"),
        List.of("jason@email.com", "제이슨"),
        List.of("woniee@email.com", "워니"),
        List.of("mj@email.com", "엠제이"),
        List.of("nowm@email.com", "이제엠"),
        List.of("qq@email.com", "이워니")
    );
    List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com", "qq@email.com",
        "woniee@email.com");
    assertThat(Problem6.solution(forms)).isEqualTo(result);
  }

  @Test
  public void testCase3() {
    List<List<String>> forms = List.of(
        List.of("jj@email.com", "제이제이"),
        List.of("woniee@email.com", "워니"),
        List.of("nowm@email.com", "이우엠"),
        List.of("qq@email.com", "이워니")
    );
    List<String> result = List.of("qq@email.com", "woniee@email.com");
    assertThat(Problem6.solution(forms)).isEqualTo(result);
  }

}