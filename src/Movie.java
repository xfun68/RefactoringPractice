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
        return price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
