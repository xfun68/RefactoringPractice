public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price price;

    public Movie(String title, int price) {
        this.title = title;
        setPriceCode(price);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case Movie.REGULAR:
                this.price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                this.price = new NewReleasePrice();
                break;
            case Movie.CHILDREN:
                this.price = new ChildrenPrice();
                break;
        }
    }

    public String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += daysRented * 3;
                break;
            case CHILDREN:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
        }
        return result;
    }

    int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;

        if (getPriceCode() == NEW_RELEASE && daysRented > 1)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }
}
