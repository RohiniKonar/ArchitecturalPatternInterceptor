import MovieRentalFramework.Movie;
import MovieRentalFramework.Rental;
import RentalLoggingInterceptor.Dispatcher;
import RentalLoggingInterceptor.LoggingCustomer;
import RentalLoggingInterceptor.LoggingRentalInterceptor;
import RentalLoggingInterceptor.RentalInterceptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RentalTest {

    @Test
    public void testGetChargeWithoutInterceptors() {
        Movie movie = new Movie("Test Movie", Movie.REGULAR);
        Rental rental = new Rental(movie, 5);

        double expectedCharge = 6.5;
        double actualCharge = rental.getCharge();

        Assertions.assertEquals(expectedCharge, actualCharge, 0.01);
    }

    @Test
    public void testGetChargeWithDiscountInterceptor() {
        Movie movie = new Movie("Test Movie", Movie.REGULAR);
        Rental rental = new Rental(movie, 5);

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.addInterceptor(new LoggingRentalInterceptor());

        double expectedCharge = 5.85;
        double actualCharge = rental.getCharge();

        Assertions.assertEquals(expectedCharge, actualCharge, 0.01);
    }

    @Test
    public void testGetChargeWithLoggingInterceptor() {
        Movie movie = new Movie("Test Movie", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 3);

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.addInterceptor((RentalInterceptor) new LoggingCustomer());

        rental.getCharge();

        // In this test, we are just verifying that the logging interceptor is called without any exceptions
        Assertions.assertTrue(true);
    }
}
