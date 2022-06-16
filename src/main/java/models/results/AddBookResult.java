package models.results;

import dynamoDb.models.Book;
import models.BookModel;

public class AddBookResult {
    private BookModel bookModel;

    public AddBookResult(BookModel bookModel) {
        this.bookModel = bookModel;
    }

    public AddBookResult(Builder builder) {
        this.bookModel = builder.bookModel;
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private BookModel bookModel;

        public Builder withBookModel(final BookModel bookModelToUse) {
            this.bookModel = bookModelToUse;
            return this;
        }

        AddBookResult build() {
            return new AddBookResult(this);
        }
    }

}
