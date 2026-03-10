package utilities;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Properties;
import java.util.Scanner;

public class MailReader {

    private final String host = "imap.gmail.com";
    private final String mailFolderName = "INBOX";
    private String result;
    private String searchText;

    public String readGmail(String userName, String password, String emailSubjectContent, String emailContent, int lengthOfOTP) throws InterruptedException, MessagingException, IOException {
        Thread.sleep(3000);
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getInstance(props);
        Store store = session.getStore();
        store.connect(host, userName, password);
        Folder inbox = store.getFolder(mailFolderName);
        inbox.open(Folder.READ_ONLY);
        int messageCount = inbox.getMessageCount();
        int unreadMsgCount = inbox.getUnreadMessageCount();
        Message emailMessage;
        String emailSubject;
        for (int i = messageCount; i > (messageCount - unreadMsgCount); i--) {
            emailMessage = inbox.getMessage(i);
            emailSubject = emailMessage.getSubject();
            if (emailSubject.contains(emailSubjectContent)) {
                String line;
                StringBuilder buffer = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(emailMessage.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    buffer.append(line.trim().replace("</", "").replace(">", "").replace("<", "").replace("h3", "").replace("h1", ""));
                }
                result = buffer.substring(buffer.toString().indexOf(emailContent));
                searchText = result.substring(emailContent.length(), emailContent.length() + lengthOfOTP).trim();
                System.out.print("OTP From Gmail##############::::" + searchText);
//                    emailMessage.setFlag(Flags.Flag.SEEN, true);
                break;
            }
            emailMessage.setFlag(Flags.Flag.SEEN, true);
        }
        return searchText;
    }

}
