import de.optischa.mail.Sessions;
import de.optischa.mail.Sender;
import de.optischa.mail.components.TopDefault;
import org.junit.Test;

import javax.mail.Session;
import java.util.List;

public class EmailTest {

    @Test
    public void sendTestEmail() {
        Session session = new Sessions(true, "false", "mail.example.de", "587", "mail.example.de", "user@example.de", "PASSWORD").getSession();
        Sender.sendEmail("form@example.com", "to@example.com", "Hello World", List.of(new TopDefault(), new TopDefault()), session);
    }

}
