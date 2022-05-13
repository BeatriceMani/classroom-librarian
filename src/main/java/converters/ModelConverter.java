package converters;

import dynamoDb.models.Book;
import models.BookModel;

import javax.inject.Inject;

public class ModelConverter {

    @Inject
    public ModelConverter() { }

    /**
     * Converts a provided {@link Book} into a {@link BookModel} representation.
     * @param book the book to convert
     * @return the converted book
     */
    public BookModel toBookModel(Book book) {
        return BookModel.builder()
                .withBookId(book.getBookId())
                .withAuthor(book.getAuthor())
                .withTitle(book.getTitle())
                .withHomeLibrary(book.getHomeLibrary())
                .withStatus(book.getStatus())
                .withCondition(book.getCondition())
                .withGenre(book.getGenre())
                .build();
    }

}
