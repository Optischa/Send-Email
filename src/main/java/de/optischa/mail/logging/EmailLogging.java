package de.optischa.mail.logging;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.*;

public class EmailLogging {

    private final Logger logger = Logger.getLogger(EmailLogging.class.getName());

    public EmailLogging() {
        try {
            File folder = new File("logs/");
            if(!folder.exists()) {
                folder.mkdir();
            }
            File file = new File("logs/lastet.log");
            if(file.exists()) {
                Path dirPath = Files.createTempDirectory("logs");
                Path filePath = Files.createTempFile(dirPath, "lastet", ".log");
                BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
                file.renameTo(new File("logs/" + attributes.creationTime().toString().replaceAll(":", " ") + ".log"));
            }
            FileHandler fileHandler = new FileHandler("logs/lastet.log");
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new LoggingFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendEmailError(MessagingException exception) {
        logger.info(exception.getMessage());
    }

}
