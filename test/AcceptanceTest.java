import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AcceptanceTest {
    @Test
    public void display_statement() {
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

        String expect = "Rental Record for Panda\n" +
                "\tRegular Movie\t3.5\n" +
                "\tChildren Movie\t3.0\n" +
                "\tNew Release Movie\t15.0\n" +
                "Amount owed is 21.5\n" +
                "You earned 4 frequent renter points";
        assertThat(customer.statement(), is(expect));
    }
}
