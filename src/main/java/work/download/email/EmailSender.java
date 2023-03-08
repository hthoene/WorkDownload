package work.download.email;

public interface EmailSender {
    void sendConfirmation(String to, String subject, String message);
}
