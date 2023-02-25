package MovieRentalFramework;

public class Rental {
    private Movie movie;
    private int daysRented;
    private boolean dispatcher;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    public double getCharge() {
        double charge = 0;
        int priceCode = movie.getPriceCode();

        if (priceCode == Movie.REGULAR) {
            charge += 2;
            if (daysRented > 2) {
                charge += (daysRented - 2) * 1.5;
            }
        } else if (priceCode == Movie.NEW_RELEASE) {
            charge += daysRented * 3;
        } else if (priceCode == Movie.CHILDRENS) {
            charge += 1.5;
            if (daysRented > 3) {
                charge += (daysRented - 3) * 1.5;
            }
        }
        if (dispatcher != null) {
            charge = dispatcher.dispatch(this, charge);
        }

        return charge;
    }

    public int getFrequentRenterPoints() {
            return movie.getFrequentRenterPoints(daysRented);
        }
    }
