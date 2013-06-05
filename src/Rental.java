public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getCharge() {
        return getMovie().getCharge(getDaysRented());
    }

    int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;

        frequentRenterPoints++;

        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }
}
