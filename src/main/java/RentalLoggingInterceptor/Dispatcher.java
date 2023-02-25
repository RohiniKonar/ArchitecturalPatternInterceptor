package RentalLoggingInterceptor;

import MovieRentalFramework.Rental;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private List<RentalInterceptor> interceptors;

    public Dispatcher() {
        interceptors = new ArrayList<>();
    }

    public void addInterceptor(RentalInterceptor interceptor) {
        interceptors.add(interceptor);
    }

    public double dispatch(Rental rental, double chargeAmt) {
        for (RentalInterceptor interceptor : interceptors) {
            chargeAmt = interceptor.intercept(rental, chargeAmt);
        }
        return chargeAmt;
    }
}

