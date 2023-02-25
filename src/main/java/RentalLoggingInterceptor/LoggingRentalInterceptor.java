package RentalLoggingInterceptor;

import MovieRentalFramework.Rental;

public class LoggingRentalInterceptor implements RentalInterceptor {
    @Override
    public double intercept(Rental rental, double chargeAmt) {
        System.out.println("Rental statement for " + rental.getMovie().getTitle() + ": " + rental.getCharge());
        return chargeAmt;
    }
}

