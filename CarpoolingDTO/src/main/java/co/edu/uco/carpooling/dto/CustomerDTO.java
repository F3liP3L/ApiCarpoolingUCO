package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class CustomerDTO {
    private UUID id;
    private String name;
    private String password;
    private String mailEntity;
    private String documentIdentity;

    public CustomerDTO(UUID id, String name, String password, String mailEntity, String documentIdentity) {
        setId(id);
        setDocumentIdentity(documentIdentity);
        setPassword(password);
        setName(name);
        setMailEntity(mailEntity);
    }

    public CustomerDTO() {
        setId(UtilUUID.getUtilUUID().getDefaultUUID(id));
        setName(EMPTY);
        setPassword(EMPTY);
        setMailEntity(EMPTY);
        setDocumentIdentity(EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilObject.getUtilObject().getDefaultIsNull(id, UtilUUID.getUtilUUID().getNewUUID());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = getUtilText().trim(name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = getUtilText().trim(password);
    }

    public String getMailEntity() {
        return mailEntity;
    }

    public void setMailEntity(String mailEntity) {
        this.mailEntity = getUtilText().trim(mailEntity);
    }

    public String getDocumentIdentity() {
        return documentIdentity;
    }

    public void setDocumentIdentity(String documentIdentity) {
        this.documentIdentity = getUtilText().trim(documentIdentity);  }

    public static final CustomerDTO create() {
        return new CustomerDTO();
    }

}
