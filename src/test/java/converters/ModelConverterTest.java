package converters;

import dynamoDb.models.Book;
import models.BookModel;
import models.Condition;
import models.Genre;
import models.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelConverterTest {

    private final String testBookId = "book123";
    private final String testAuthor = "Rick Riordan";
    private final String testTitle = "Percy Jackson";
    private final String testHomeLibrary = "505";
    private final Status testStatus = Status.AVAILABLE;
    private final Condition testCondition = Condition.FAIR;
    private final Genre testGenre = Genre.FICTON;

    private ModelConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new ModelConverter();
    }

    @Test
    public void toBookModel_withAllAttributes_returnsCorrectBookModel() {
        // GIVEN
        Book book = Book.builder()
                .withBookId(testBookId)
                .withAuthor(testAuthor)
                .withTitle(testTitle)
                .withHomeLibrary(testHomeLibrary)
                .withStatus(testStatus)
                .withCondition(testCondition)
                .withGenre(testGenre)
                .build();

        // WHEN
        BookModel bookModel = converter.toBookModel(book);

        // THEN
        assertEquals(testBookId, bookModel.getBookId(),
                String.format("Expected bookId to be %s, but was %s", testBookId, bookModel.getBookId()));
        assertEquals(testAuthor, bookModel.getAuthor(),
                String.format("Expected author to be %s, but was %s", testAuthor, bookModel.getAuthor()));
        assertEquals(testTitle, bookModel.getTitle(),
                String.format("Expected author to be %s, but was %s", testTitle, bookModel.getTitle()));
        assertEquals(testHomeLibrary, bookModel.getHomeLibrary(),
                String.format("Expected homeLibrary to be %s, but was %s", testHomeLibrary, bookModel.getHomeLibrary()));
        assertEquals(testStatus, bookModel.getStatus(),
                String.format("Expected author to be %s, but was %s", testStatus, bookModel.getStatus()));
        assertEquals(testCondition, bookModel.getCondition(),
                String.format("Expected author to be %s, but was %s", testCondition, bookModel.getCondition()));
        assertEquals(testGenre, bookModel.getGenre(),
                String.format("Expected author to be %s, but was %s", testGenre, bookModel.getGenre()));
    }

    @Test
    public void toBookModel_withOnlyRequiredAttributes_returnsCorrectBook() {
        // GIVEN
        Book book = Book.builder()
                .withBookId(testBookId)
                .withAuthor(testAuthor)
                .withTitle(testTitle)
                .build();

        // WHEN
        BookModel bookModel = converter.toBookModel(book);

        // THEN
        assertEquals(testBookId, bookModel.getBookId(),
                String.format("Expected bookId to be %s, but was %s", testBookId, bookModel.getBookId()));
        assertEquals(testAuthor, bookModel.getAuthor(),
                String.format("Expected author to be %s, but was %s", testAuthor, bookModel.getAuthor()));
        assertEquals(testTitle, bookModel.getTitle(),
                String.format("Expected author to be %s, but was %s", testTitle, bookModel.getTitle()));

    }

}
