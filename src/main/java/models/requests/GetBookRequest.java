package models.requests;

import java.util.Objects;

/**
 * Implementation of the GetBookRequest class
 */
public class GetBookRequest {
    private String bookId;

    public GetBookRequest () {}

    public GetBookRequest (String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetBookRequest that = (GetBookRequest) o;
        return getBookId().equals(that.getBookId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId());
    }

    @Override
    public String toString() {
        return "GetBookRequest{" +
                "bookId='" + bookId + '\'' +
                '}';
    }


}
