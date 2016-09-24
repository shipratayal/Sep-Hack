package issuetracker

import com.MailCO
import com.sparkpost.Client
import com.sparkpost.exception.SparkPostException
import com.sparkpost.model.AddressAttributes
import com.sparkpost.model.AttachmentAttributes
import com.sparkpost.model.RecipientAttributes
import com.sparkpost.model.TemplateContentAttributes
import com.sparkpost.model.TransmissionWithRecipientArray
import com.sparkpost.model.responses.Response
import com.sparkpost.resources.ResourceTransmissions
import com.sparkpost.transport.RestConnection


class MailService {


    def groovyPageRenderer


    public void sendSimpleMailWithoutAttachment(MailCO mailCO) throws SparkPostException {
        try {
            String API_KEY = "0070ec20083536a592c7d91944a60ad803fb833f";
            Client sparky = new Client(API_KEY);
            mailCO.from = "testing@sparkpostbox.com"
            com.sparkpost.model.responses.Response response = sparky.sendMessage(
                    mailCO.from,
                    mailCO.to,
                    mailCO.subject,
                    "",
                    groovyPageRenderer.render(view: mailCO.viewFileName, model: mailCO.modelMap)
            )
            println("======== Mail has been sent successfully")
        }
        catch (Exception e) {
            println("======== There occurred exception while sending mail = ${e.message}")
            e.printStackTrace()
        }
    }

    public void sendMailWithAttachment(MailCO mailCO, List<File> files) throws SparkPostException {
        try {
            TransmissionWithRecipientArray transmission = new TransmissionWithRecipientArray();
            String API_KEY = "0070ec20083536a592c7d91944a60ad803fb833f";
            Client client1 = new Client(API_KEY);
            // Populate Recipients
            List<RecipientAttributes> recipientArray = new ArrayList<RecipientAttributes>();
            mailCO.to.each { recipient ->
                RecipientAttributes recipientAttribs = new RecipientAttributes();
                recipientAttribs.setAddress(new AddressAttributes(recipient));
                recipientArray.add(recipientAttribs);
            }
            transmission.setRecipientArray(recipientArray);
            // Populate Substitution Data
            /*Map<String, Object> substitutionData = new HashMap<String, Object>();
            substitutionData.put("yourContent", "You can add substitution data too.");
            transmission.setSubstitutionData(substitutionData);*/

            // Populate Email Body
            TemplateContentAttributes contentAttributes = new TemplateContentAttributes();
            contentAttributes.setFrom(new AddressAttributes("testing@sparkpostbox.com"));
            contentAttributes.setSubject(mailCO.subject);
            contentAttributes.setText("");
            contentAttributes.setHtml(groovyPageRenderer.render(view: mailCO.viewFileName, model: mailCO.modelMap));
            List<AttachmentAttributes> attachmentAttributes = []
            files.each { file ->
                AttachmentAttributes attribute = new AttachmentAttributes()
                attribute.type = "application/pdf"
                attribute.name = file.name
                attribute.data = file.bytes.encodeAsBase64()
                attachmentAttributes.add(attribute)
            }
            contentAttributes.setAttachments(attachmentAttributes)
            transmission.setContentAttributes(contentAttributes);

            // Send the Email

            RestConnection connection = new RestConnection(client1);
            Response response = ResourceTransmissions.create(connection, 0, transmission);
            println("^^^^^^^^^^^^ Mail has been sent successfully and response = ${response}")
        }
        catch (Exception e) {
            println("===========There occurred exception while sending mail = " + e.message)
            e.printStackTrace()
        }

    }


}
