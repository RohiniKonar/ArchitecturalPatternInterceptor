package RentalLoggingInterceptor;

import MovieRentalFramework.Rental;

public interface RentalInterceptor {
    double intercept(Rental rental, double charge);
}
//This one is important

