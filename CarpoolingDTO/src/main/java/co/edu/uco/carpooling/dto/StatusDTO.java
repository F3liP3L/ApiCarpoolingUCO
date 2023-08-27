package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import java.util.UUID;

public class StatusDTO {
    private UUID id;
    private String status;

    public StatusDTO(UUID id, String status) {
        setId(id);
        setStatus(status);
    }

    public StatusDTO() {
        setId(UtilUUID.getUtilUUID().getDefaultUUID(id));
        setStatus(EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilObject.getUtilObject().getDefaultIsNull(id, UtilUUID.DEFAULT_UUID);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = getUtilText().getDefault(status, EMPTY);
    }

    public static final StatusDTO create() {
        return new StatusDTO();
    }
}