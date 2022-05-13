package dynamoDb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import models.Condition;
import models.Genre;
import models.Status;

import java.util.Objects;


/**
 * Represents an item in the Books table.
 */
@DynamoDBTable(tableName = "Books")
public class Book {
    private String bookId;
    private String author;
    private String title;
    private String homeLibrary;
    private Status status;
    private Condition condition;
    private Genre genre;


    public Book() { }

    public Book(final Builder builder) {
        this.bookId = builder.bookId;
        this.author = builder.author;
        this.title = builder.title;
        this.homeLibrary = builder.homeLibrary;
        this.status = builder.status;
        this.condition = builder.condition;
        this.genre = builder.genre;
    }

    @DynamoDBHashKey(attributeName = "bookId")
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @DynamoDBAttribute(attributeName = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @DynamoDBAttribute(attributeName = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute(attributeName = "homeLibrary")
    public String getHomeLibrary() {
        return homeLibrary;
    }

    public void setHomeLibrary(String homeLibrary) {
        this.homeLibrary = homeLibrary;
    }

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "status")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "condition")
    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "genre")
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }




    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", homeLibrary='" + homeLibrary + '\'' +
                ", status=" + status +
                ", condition=" + condition +
                ", genre=" + genre +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getBookId().equals(book.getBookId()) && getAuthor().equals(book.getAuthor()) && getTitle().equals(book.getTitle()) && Objects.equals(getHomeLibrary(), book.getHomeLibrary()) && getStatus() == book.getStatus() && getCondition() == book.getCondition() && getGenre() == book.getGenre();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getAuthor(), getTitle(), getHomeLibrary(), getStatus(), getCondition(), getGenre());
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Implementation of the Book Builder class.
     */
    public static final class Builder {
        private String bookId;
        private String author;
        private String title;
        private String homeLibrary;
        private Status status;
        private Condition condition;
        private Genre genre;

        public Builder withBookId(final String bookIdToUse) {
            this.bookId = bookIdToUse;
            return this;
        }

        public Builder withAuthor(final String authorToUse) {
            this.author = authorToUse;
            return this;
        }

        public Builder withTitle(final String titleToUse) {
            this.title = titleToUse;
            return this;
        }

        public Builder withHomeLibrary(final String homeLibraryToUse) {
            this.homeLibrary = homeLibraryToUse;
            return this;
        }

        public Builder withStatus(final Status statusToUse) {
            this.status = statusToUse;
            return this;
        }

        public Builder withCondition(final Condition conditionToUse) {
            this.condition = conditionToUse;
            return this;
        }

        public Builder withGenre(final Genre genreToUse) {
            this.genre = genreToUse;
            return this;
        }

        public Book build() {
            return new Book(this);
        }

    }

}