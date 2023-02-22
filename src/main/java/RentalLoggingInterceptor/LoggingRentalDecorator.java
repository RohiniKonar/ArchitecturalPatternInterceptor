package RentalLoggingInterceptor;

import MovieRentalFramework.Movie;
import MovieRentalFramework.Rental;

public class LoggingRentalDecorator extends Rental {
    public LoggingRentalDecorator(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    public double getCharge() {
        double charge = super.getCharge();
        System.out.println("Charge for " + getMovie().getTitle() + ": " + charge);
        return charge;
    }

    @Override
    public int getFrequentRenterPoints() {
        int frequentRenterPoints = super.getFrequentRenterPoints();
        System.out.println("Frequent renter points for " + getMovie().getTitle() + ": " + frequentRenterPoints);
        return frequentRenterPoints;
    }
}

