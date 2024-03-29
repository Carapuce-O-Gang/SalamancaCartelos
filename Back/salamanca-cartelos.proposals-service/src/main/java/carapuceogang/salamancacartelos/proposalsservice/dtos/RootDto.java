package carapuceogang.salamancacartelos.proposalsservice.dtos;

public class RootDto {

    public String name;
    public String version;

    public RootDto(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
