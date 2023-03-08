package work.download.email;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import work.download.appuser.AppUser;
import work.download.delivery.BasicDeliveryDto;
import work.download.delivery.Delivery;
import work.download.delivery.DeliveryRepository;
import work.download.delivery.DeliveryService;
import work.download.email.request.ContactRequest;
import work.download.utils.GlobalConfig;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@AllArgsConstructor
@Service
public class EmailSendService {

    private final JavaMailSender mailSender;
    private final EmailTemplateGenerator emailTemplateGenerator;

    private final ModelMapper modelMapper;

    private final DeliveryRepository deliveryRepository;

    public String canSendDeliveryCreated(Delivery delivery) {
        if(delivery.getSentCreatedEmail()) return "You already sent this email to the client";
        return "Success";
    }

    public String canSendDelivered(Delivery delivery) {
        if(delivery.getSentDeliveredEmail()) return "You already sent this email to the client";
        return "Success";
    }


    @Async
    public String sendDeliveredToClient(Delivery delivery) {

        BasicDeliveryDto deliveryDto = modelMapper.map(delivery, BasicDeliveryDto.class);

        String downloadLink = GlobalConfig.getInstance().getFrontendUrl() + delivery.getUrlName();

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(emailTemplateGenerator.createDeliveredEmail(delivery.getOwner().getCompanyName(), deliveryDto.getDeliveredAtText(), delivery.getPassword(), downloadLink, "https://work.download/"), true);
            helper.setTo(delivery.getClientEmail());
            helper.setSubject("Your files are ready!");
            helper.setFrom(new InternetAddress("no-reply@work.download", "WorkDownload"));
            mailSender.send(mimeMessage);

            delivery.setSentDeliveredEmail(true);

            deliveryRepository.save(delivery);
        } catch (Exception e) {
            return "Could not send Email, make sure the email is correct";
        }
        return "Success";
    }

    @Async
    public String sendDeliveryCreatedToClient(Delivery delivery) {
        BasicDeliveryDto deliveryDto = modelMapper.map(delivery, BasicDeliveryDto.class);

        String downloadLink = GlobalConfig.getInstance().getFrontendUrl() + delivery.getUrlName();

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(emailTemplateGenerator.createDeliveredEmail(delivery.getOwner().getCompanyName(), deliveryDto.getDeliveryDateText(), delivery.getPassword(), downloadLink, "https://work.download/"), true);
            helper.setTo(delivery.getClientEmail());
            helper.setSubject("A delivery got created");
            helper.setFrom(new InternetAddress("no-reply@work.download", "WorkDownload"));
            mailSender.send(mimeMessage);

            delivery.setSentCreatedEmail(true);

            deliveryRepository.save(delivery);

        } catch (Exception e) {
            return "Could not send Email, make sure the email is correct";
        }
        return "Success";
    }

    @Async
    public String sendPasswordReset(String email, String token) {

        String link = GlobalConfig.getInstance().getFrontendUrl() + "reset?token=" + token;

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(emailTemplateGenerator.createPasswordResetEmail(link), true);
            helper.setTo(email);
            helper.setSubject("Password Reset");
            helper.setFrom(new InternetAddress("no-reply@work.download", "WorkDownload"));
            mailSender.send(mimeMessage);

        } catch (Exception e) {
            return "Could not send Email, make sure the email is correct";
        }
        return "Success";
    }

    public String sendContact(ContactRequest request) {

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText("Contact from: " + request.getEmail() + "<br>Name: " + request.getName() + "<br>Message:<br>" + request.getMessage(), true);
            helper.setTo("contact@work.download");
            helper.setSubject("Contact From Request");
            helper.setFrom(new InternetAddress("no-reply@work.download", "WorkDownload"));
            mailSender.send(mimeMessage);

        } catch (Exception e) {
            return "Could not send Email, make sure the email is correct";
        }
        return "Success";

    }
}
