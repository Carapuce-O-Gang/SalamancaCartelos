package carapuceogang.salamancacartelos.proposalsservice.dtos;

public class VoteDto {
    private Long userId;
    private Boolean isVoted;

    public VoteDto(Long userId, Boolean isVoted) {
        this.userId = userId;
        this.isVoted = isVoted;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getVoted() {
        return isVoted;
    }

    public void setVoted(Boolean voted) {
        isVoted = voted;
    }
}
