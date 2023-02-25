package MovieRentalFramework;

public class GeneralPrice extends PriceDetails {

    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double amount = 5;
        if (daysRented > 1)
            amount += (daysRented - 1) * 2.5;
        return amount;
    }
}
