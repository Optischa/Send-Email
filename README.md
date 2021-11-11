# Send-Email

###Vereinfacht ihnen das Senden von E-Mails in Java. 


## Verwendung

```java
public class TestEmail {
    Session session = new Sessions(true, "false", "mail.server.de", "587", "mail.example.de", "user@example.de", "PASSWORD").getSession();
    Sender.sendEmail("server@example.com", "server@example.com", "Hello World", List.of(new TopDefault()), session);
}
```

## Standart Mailserver Ports

| Service | Encryption | Port |
| ------------- | ------------- | ------------- |
| IMAP | STARTTLS | 143  |
| IMAPS | SSL | 993  |
| POP3 | STARTTLS | 110  |
| POP3S | SSL | 995  |
| SMTP | STARTTLS | 587 |
| SMTPS | SSL | 465 |

### Mehr Methoden

Es gibt auch noch die Methoden:
```java
Session session = new Sessions("false", "mail.server.de", "587", "mail.server.de", "test@server.de", "").getSession();
Session session = new Sessions("mail.server.de", "587", "mail.server.de", "test@server.de", "")getSession();
```

Unterschied zwischen den ist, dass man beo den ganz oben alles Einstellen kann. Beim zweiten kann man noch weniger Einstellen.
Beim dritten ist es amwenigsten.

### Wie kann ich meine eigenen `Components` schreiben?

```java
   public class TestComponent implements Component {

    @Override
    public String body() {
        // Hier kommt der Text rein
        return null;
    }

    @Override
    public String file() {
        // Falls es eine HTML Datei gibt in den resources Ordner und dann den Pfad angeben
        return null;
    }
} 
```

Beim implements Component werden automatisch `body()` und `file()` generiert.

##### Mitgearbeitet

<a href="https://github.com/Optischa/Send-Email/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Optischa/Send-Email" alt="Contributors"/>
</a>
