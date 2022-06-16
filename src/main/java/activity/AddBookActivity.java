package activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import converters.ModelConverter;
import dynamoDb.CatalogDao;
import dynamoDb.models.Book;
import exceptions.InvalidAttributeValueException;
import models.requests.AddBookRequest;
import models.results.AddBookResult;
import util.ClassroomLibrarianUtils;


public class AddBookActivity {
    private final CatalogDao catalogDao;
    private ModelConverter converter;

    public AddBookActivity(CatalogDao catalogDao, ModelConverter converter) {
        this.catalogDao = catalogDao;
        this.converter = converter;
    }

    public AddBookResult handleRequest(final AddBookRequest request, Context context) throws InvalidAttributeValueException {
        LambdaLogger lambdaLogger = context.getLogger();
        lambdaLogger.log("Received GetBookRequest");

        if (! ClassroomLibrarianUtils.validateString(request.getTitle())) {
            throw new InvalidAttributeValueException("Invalid title provided");
        }

        if (! ClassroomLibrarianUtils.validateString(request.getAuthor())) {
            throw new InvalidAttributeValueException("Invalid author provided");
        }

        String bookId = ClassroomLibrarianUtils.generateId();

        // TODO: check Catalog to see if this bookId already exists

        Book book = new Book.Builder()
                .withGenre(request.getGenre())
                .withCondition(request.getCondition())
                .withStatus(request.getStatus())
                .withTitle(request.getTitle())
                .withBookId(bookId)
                .withAuthor(request.getAuthor())
                .withHomeLibrary(request.getHomeLibrary())
                .build();

        catalogDao.addBook(book);

        return new AddBookResult(converter.toBookModel(book));

    }

}
