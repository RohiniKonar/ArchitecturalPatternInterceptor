package RentalLoggingInterceptor;

import MovieRentalFramework.Rental;

public class RentalLoggingInterceptor implements RentalInterceptor {
    @Override
    public double intercept(Rental rental, double charge) {
        System.out.println("Logging rental statement for " + rental.getMovie().getTitle() + "...");
        System.out.println("Days rented: " + rental.getDaysRented());
        System.out.println("Rental charge: " + rental.getCharge());
        System.out.println("Frequent renter points earned: " + rental.getFrequentRenterPoints());
        System.out.println("============================");
        return charge;
    }
}
