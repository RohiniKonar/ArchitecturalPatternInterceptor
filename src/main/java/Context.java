
public interface Context {
    void setState(State state);
    State getState();

    String getMessage();
    void setMessage(String message);
}