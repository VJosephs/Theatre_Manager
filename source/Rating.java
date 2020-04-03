package source;

public class Rating {
    private String userName;
    private String comment;
    private double rating;

    public Rating(double rating, String userName, String comment) {
        setRating(rating);
        this.userName = userName;
        this.comment = comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private void setRating(double rating) {
        // TODO make sure rating is in valid range
    }

    public String getUserName() {
        return userName;
    }

    public String getComment() {
        return comment;
    }

    public double getRating() {
        return rating;
    }

    public String toString() {
        // TODO add method body
        return null;
    }
}