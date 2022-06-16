package models.requests;

import models.Condition;
import models.Genre;
import models.Status;

import java.util.Objects;


public class AddBookRequest {
    private String author;
    private String title;
    private String homeLibrary;
    private Status status;
    private Condition condition;
    private Genre genre;


    public AddBookRequest() {}

    public AddBookRequest(final Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.homeLibrary = builder.homeLibrary;
        this.status = builder.status;
        this.condition = builder.condition;
        this.genre = builder.genre;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHomeLibrary() {
        return homeLibrary;
    }

    public void setHomeLibrary(String homeLibrary) {
        this.homeLibrary = homeLibrary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddBookRequest that = (AddBookRequest) o;
        return getAuthor().equals(that.getAuthor()) && getTitle().equals(that.getTitle()) && getHomeLibrary().equals(that.getHomeLibrary()) && getStatus() == that.getStatus() && getCondition() == that.getCondition() && getGenre() == that.getGenre();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getTitle(), getHomeLibrary(), getStatus(), getCondition(), getGenre());
    }

    @Override
    public String toString() {
        return "AddBookRequest{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", homeLibrary='" + homeLibrary + '\'' +
                ", status=" + status +
                ", condition=" + condition +
                ", genre=" + genre +
                '}';
    }

    public static Builder builder() {return new Builder();}

    /**
     * Implementation of the AddBookRequest Builder class.
     */

    public static final class Builder {
        private String author;
        private String title;
        private String homeLibrary;
        private Status status;
        private Condition condition;
        private Genre genre;

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

        private  Builder withCondition(final  Condition conditionToUse) {
            this.condition = conditionToUse;
            return this;
        }

        private Builder withGenre(final Genre genreToUse) {
            this.genre = genreToUse;
            return this;
        }

        public AddBookRequest build() {return new AddBookRequest(this);}


    }


}
