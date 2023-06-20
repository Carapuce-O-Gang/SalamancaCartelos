package carapuceogang.salamancacartelos.proposalsservice.dtos;

public class StatusDto {

    public Boolean online;

    public StatusDto(Boolean online) {
        this.online = online;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}
