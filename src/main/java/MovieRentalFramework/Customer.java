package MovieRentalFramework;

import RentalLoggingInterceptor.Dispatcher;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    protected String name;
    protected List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    /*public void addRental(Rental rental) {
        rentals.add(rental);
    }*/

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "MovieRentalFramework.Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rental.getCharge()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental : rentals) {
            result += rental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
        dispatcher.dispatch(rental);
    }
}
