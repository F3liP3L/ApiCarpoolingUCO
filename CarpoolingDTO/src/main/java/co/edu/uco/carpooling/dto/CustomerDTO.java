package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
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
        setName(UtilText.EMPTY);
        setPassword(UtilText.EMPTY);
        setMailEntity(UtilText.EMPTY);
        setDocumentIdentity(UtilText.EMPTY);
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
        this.name = UtilText.getUtilText().getDefault(name, UtilText.EMPTY);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = UtilText.getUtilText().getDefault(password, UtilText.EMPTY);
    }

    public String getMailEntity() {
        return mailEntity;
    }

    public void setMailEntity(String mailEntity) {
        this.mailEntity = UtilText.getUtilText().getDefault(mailEntity, UtilText.EMPTY);
    }

    public String getDocumentIdentity() {
        return documentIdentity;
    }

    public void setDocumentIdentity(String documentIdentity) {
        this.documentIdentity = UtilText.getUtilText().getDefault(documentIdentity, UtilText.EMPTY);
    }

    public static final CustomerDTO create() {
        return new CustomerDTO();
    }
}
