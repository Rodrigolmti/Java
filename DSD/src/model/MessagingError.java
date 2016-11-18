package model;

/**
 * Model for handle errors in general
 * @author Amanda Nunes / Rodrigo Lopes
 */
public class MessagingError {
 
    private String message;
    
    private String localizedError;

    public MessagingError(String message, String localizedError) {
        this.message = message;
        this.localizedError = localizedError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocalizedError() {
        return localizedError;
    }

    public void setLocalizedError(String localizedError) {
        this.localizedError = localizedError;
    } 
}
