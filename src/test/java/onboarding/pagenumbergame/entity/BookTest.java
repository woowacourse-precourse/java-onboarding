package onboarding.pagenumbergame.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookTest {

  @Test
  public void bookInitTest() throws Exception {
    int pageOne = 100;
    int pageTwo = 101;
    Page page1 = Page.from(pageOne);
    Page page2 = Page.from(pageTwo);

    Book book = Book.of(List.of(pageOne, pageTwo));

    assertThat(book.printPages()).contains(page1, page2);
  }

  @DisplayName("Book Entity exception Test")
  @Test
  public void bookPageSizeOutOfTwo() throws Exception {
    List<Integer> pages = List.of(1, 2, 3);
    List<Integer> exceptionPages = List.of(-1, -1, -1);
    Book book = Book.of(pages);
    assertThat(book.printPages()).isEqualTo(Book.of(exceptionPages).printPages());
  }

}
