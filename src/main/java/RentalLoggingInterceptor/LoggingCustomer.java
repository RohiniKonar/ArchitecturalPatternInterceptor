package RentalLoggingInterceptor;

import MovieRentalFramework.Customer;
import MovieRentalFramework.Rental;

public class LoggingCustomer extends Customer {
    public LoggingCustomer() {
        super(name);
    }

    @Override
    public void addRental(Rental rental) {
        rentals.add(new LoggingRentalDecorator(rental.getMovie(), rental.getDaysRented()));
    }
}
