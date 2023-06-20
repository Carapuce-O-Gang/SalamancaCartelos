package carapuceogang.salamancacartelos.proposalsservice.dtos;

public class MessageDto {
    private Long id;
    private String content;
    private Long userId;
    private DiscussionDto discussion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public DiscussionDto getDiscussion() {
        return discussion;
    }

    public void setDiscussion(DiscussionDto discussion) {
        this.discussion = discussion;
    }
}
