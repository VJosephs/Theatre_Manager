

public class Rating {


    private String userName;
    private String comment;
    private double rating;

    /**
     * @param rating   taken 1 out of 5 to determine how entertaining the movie was
     * @param userName the name to know which account is rating
     * @param comment  comment for the user to make for why the rating is what it is
     */

    public Rating(double rating, String userName, String comment) {
        setRating(rating);
        this.userName = userName;
        this.comment = comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @param rating 1 out of 5 to know how entertaingin the movie was
     */
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        long temp;
        temp = Double.doubleToLongBits(rating);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rating other = (Rating) obj;
        if (comment == null) {
            if (other.comment != null)
                return false;
        } else if (!comment.equals(other.comment))
            return false;
        if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
            return false;
        if (userName == null) {
            return other.userName == null;
        } else return userName.equals(other.userName);
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
