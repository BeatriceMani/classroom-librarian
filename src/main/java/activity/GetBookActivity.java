package activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import converters.ModelConverter;
import dynamoDb.CatalogDao;
import dynamoDb.models.Book;
import exceptions.BookNotFoundException;
import models.requests.GetBookRequest;
import models.results.GetBookResult;

import javax.inject.Inject;

public class GetBookActivity {
    private final CatalogDao catalogDao;
    private ModelConverter converter;

    @Inject
    public GetBookActivity(CatalogDao catalogDao, ModelConverter converter) {
        this.catalogDao = catalogDao;
        this.converter = converter;
    }

    public GetBookResult handleRequest(final GetBookRequest request, Context context) throws BookNotFoundException{
        LambdaLogger lambdaLogger = context.getLogger();
        lambdaLogger.log("Received GetBookRequest for bookId " + request.getBookId());

        Book book;

        try {
            book = catalogDao.getBook(request.getBookId());
        } catch (BookNotFoundException bnfe) {
            throw bnfe;
        }

        return GetBookResult.builder()
                .withBookModel(converter.toBookModel(book))
                .build();

    }


}
