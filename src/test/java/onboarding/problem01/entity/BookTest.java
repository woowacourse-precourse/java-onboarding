package onboarding.problem01.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookTest {

  @Test
  public void bookInitTest() throws Exception {
    int pageOne = 101;
    int pageTwo = 102;
    Page page1 = Page.from(pageOne);
    Page page2 = Page.from(pageTwo);

    Book book = Book.of(List.of(pageOne, pageTwo));

    assertThat(book.printPages()).contains(page1, page2);
  }

  @DisplayName("Size exception Test")
  @Test
  public void bookPageSizeOutOfTwo() throws Exception {
    List<Integer> pages = List.of(1, 2, 3);
    List<Integer> exceptionPages = List.of(-1, -1, -1);
    Book book = Book.of(pages);
    assertThat(book.printPages()).isEqualTo(Book.of(exceptionPages).printPages());
  }

  @DisplayName("Position exception Test")
  @Test
  public void bookPagePositionExceptionTest() throws Exception {
    List<Integer> pages = List.of(2,1);
    List<Integer> exceptionPages = List.of(-1, -1);
    Book book = Book.of(pages);
    assertThat(book.printPages()).isEqualTo(Book.of(exceptionPages).printPages());
  }

  @DisplayName("Number exception Test")
  @Test
  public void bookPageNumberExceptionTest() throws Exception {
    List<Integer> pages = List.of(4, 10);
    List<Integer> exceptionPages = List.of(-1, -1);
    Book book = Book.of(pages);
    assertThat(book.printPages()).isEqualTo(Book.of(exceptionPages).printPages());
  }

}
