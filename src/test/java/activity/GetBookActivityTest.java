package activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import converters.ModelConverter;
import dynamoDb.CatalogDao;
import dynamoDb.models.Book;
import exceptions.BookNotFoundException;
import models.BookModel;
import models.Condition;
import models.Genre;
import models.Status;
import models.requests.GetBookRequest;
import models.results.GetBookResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class GetBookActivityTest {

    private final String testBookId = "book123";
    private final String notABookId = "noBookHere";
    private final String testAuthor = "Rick Riordan";
    private final String testTitle = "Percy Jackson";
    private final String testHomeLibrary = "505";
    private final Status testStatus = Status.AVAILABLE;
    private final Condition testCondition = Condition.FAIR;
    private final Genre testGenre = Genre.FICTON;


    @Mock
    private CatalogDao catalogDao;

    @Mock
    private ModelConverter converter;

    @Mock
    private Context context;

    private GetBookActivity getBookActivity;
    private LambdaLogger lambdaLogger;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        getBookActivity = new GetBookActivity(catalogDao, converter);
        lambdaLogger = new LambdaLogger() {
            @Override
            public void log(String message) {
                System.out.println(message);
            }

            @Override
            public void log(byte[] message) {
                System.out.println(message);
            }
        };
    }

    @Test
    public void getBook_bookInCatalog_returnsBook(){
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

        BookModel bookModel = BookModel.builder()
                .withBookId(testBookId)
                .withAuthor(testAuthor)
                .withTitle(testTitle)
                .withHomeLibrary(testHomeLibrary)
                .withStatus(testStatus)
                .withCondition(testCondition)
                .withGenre(testGenre)
                .build();

        when(catalogDao.getBook(testBookId)).thenReturn(book);
        when(converter.toBookModel(book)).thenReturn(bookModel);
        when(context.getLogger()).thenReturn(lambdaLogger);

        GetBookRequest request = new GetBookRequest(testBookId);

        // WHEN
        GetBookResult result = getBookActivity.handleRequest(request, context);

        // THEN
        assertEquals(bookModel.getBookId(), result.getBookModel().getBookId(),
                String.format("Expected bookId to be %s, but was %s.", bookModel.getBookId(), result.getBookModel().getBookId()));
        assertEquals(bookModel.getAuthor(), result.getBookModel().getAuthor(),
                String.format("Expected author to be %s, but was %s.", bookModel.getAuthor(), result.getBookModel().getAuthor()));
        assertEquals(bookModel.getTitle(), result.getBookModel().getTitle(),
                String.format("Expected title to be %s, but was %s.", bookModel.getTitle(), result.getBookModel().getTitle()));

    }

    @Test
    public void getBook_bookNotInCatalog_throwsException() {

        // GIVEN
        GetBookRequest request = new GetBookRequest(notABookId);
        when(catalogDao.getBook(notABookId)).thenThrow(BookNotFoundException.class);
        when(context.getLogger()).thenReturn(lambdaLogger);

        // WHEN + THEN
        assertThrows(BookNotFoundException.class, () -> {
            getBookActivity.handleRequest(request, context);
        });

    }


}
