package models.results;

import models.BookModel;

public class GetBookResult {
    private BookModel bookModel;

    public GetBookResult(Builder builder) {
        this.bookModel = builder.bookModel;
    }

    public BookModel getBookModel() {
        return bookModel;
    }

    public void setBookModel(BookModel bookModel) {
        this.bookModel = bookModel;
    }

    public static Builder builder() {
       return new Builder();
    }

    public static final class Builder {
        private BookModel bookModel;

        public Builder withBookModel(final BookModel bookModelToUse){
            this.bookModel = bookModelToUse;
            return this;
        }

        public GetBookResult build() {
            return new GetBookResult(this);
        }
    }



}
