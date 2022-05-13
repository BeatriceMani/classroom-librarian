package dynamoDb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamoDb.models.Book;
import exceptions.BookNotFoundException;

import javax.inject.Inject;

public class CatalogDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public CatalogDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Book getBook(String bookId) throws BookNotFoundException {
        Book book = dynamoDBMapper.load(Book.class, bookId);

        if (book == null) {
            throw new BookNotFoundException(String.format("Could not find book for bookId %s", bookId));
        }

        return book;
    }
}
