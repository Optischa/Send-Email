import de.optischa.mail.Mail;
import org.junit.Test;

public class EmailTest {

    @Test
    public void sendTestEmail() {
        Mail mail = new Mail(true, "false", "mail.server.de", "25", "mail.server.de", "test@server.de", "");
        mail.sendEmail("test@server.de", "to@email.de", "Title from email", "Message from body");
    }

}
