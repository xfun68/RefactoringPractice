public class Main {
    public static void main(String[] args) {
        Movie regularMovie = new Movie("Regular Movie", Movie.REGULAR);
        Rental regularMovieRental = new Rental(regularMovie, 3);

        Movie childrenMovie = new Movie("Children Movie", Movie.CHILDREN);
        Rental childrenMovieRental = new Rental(childrenMovie, 4);

        Movie newReleaseMovie = new Movie("New Release Movie", Movie.NEW_RELEASE);
        Rental newReleaseMovieRental = new Rental(newReleaseMovie, 5);

        Customer customer = new Customer("Panda");
        customer.addRental(regularMovieRental);
        customer.addRental(childrenMovieRental);
        customer.addRental(newReleaseMovieRental);

        System.out.println(customer.statement());
    }
}
