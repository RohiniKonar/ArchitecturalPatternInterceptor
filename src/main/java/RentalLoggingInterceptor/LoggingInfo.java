package RentalLoggingInterceptor;

import java.time.LocalDateTime;

public class LoggingInfo implements LoggingContext{
    private String customerName = null;
    private String movieName;
    private LocalDateTime timestamp;

    public LoggingInfo() {
        this.customerName = customerName;
        this.movieName = movieName;
        this.timestamp = timestamp;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMovieName() {
        return movieName;
    }
}
