

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
        if (rating == 1 || rating == 1.5 || rating == 2 || rating == 2.5 || rating == 3 || rating == 3.5 || rating == 4 || rating == 4.5 || rating == 5) {
            this.rating = rating;
        } else if (rating < 1) {
            this.rating = 1;
        } else if (rating > 5) {
            this.rating = 5;
        } else {
            this.rating = Math.round(rating);
        }
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
        return userName + "gave this show a rating of:" + rating + " and said, " + comment;
    }
}