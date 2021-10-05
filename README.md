# Send-Email

Vereinfacht dir das senden von Email's in Java

```java
  Mail mail = new Mail(true, "false", "mail.server.de", "25", "mail.server.de", "test@server.de", "");
  mail.sendEmail("test@server.de", "to@email.de", "Title from email", "Message from body");
```

### Was kommt alles bei ```Message from body``` rein?

Da kann man HTML Elemente oder auch normalen Text rein machen.

### Mehr Methoden

Es gibt auch noch die Methoden:
```java
   Mail mail = new Mail("false", "mail.server.de", "25", "mail.server.de", "test@server.de", "");
   Mail mail = new Mail("mail.server.de", "25", "mail.server.de", "test@server.de", "");
```

Unterschied zwischen den ist, dass man beo den ganz oben alles Einstellen kann. Beim zweiten kann man noch weniger Einstellen.
Beim dritten ist es amwenigsten.

#### Sollte es fragen geben können sie mich gerne Anschreiben
