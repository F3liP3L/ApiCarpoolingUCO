package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class CustomerDomain {
    private UUID id;
    private String name;
    private String password;
    private String mailEntity;
    private String documentIdentity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = UtilText.getUtilText().getDefault(name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = UtilText.getUtilText().getDefault(password);
    }

    public String getMailEntity() {
        return mailEntity;
    }

    public void setMailEntity(String mailEntity) {
        this.mailEntity = UtilText.getUtilText().getDefault(mailEntity);
    }

    public String getDocumentIdentity() {
        return documentIdentity;
    }

    public void setDocumentIdentity(String documentIdentity) {
        this.documentIdentity = UtilText.getUtilText().getDefault(documentIdentity);
    }
}
