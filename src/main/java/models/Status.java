package models;

public enum Status {
    /**
     * Book available for checkout.
     */
    AVAILABLE,
    /**
     * Book currently checked out, not available.
     */
    CHECKED_OUT,
    /**
     * Book removed from circulation
     */
    REMOVED_FROM_CIRCULATION
}
