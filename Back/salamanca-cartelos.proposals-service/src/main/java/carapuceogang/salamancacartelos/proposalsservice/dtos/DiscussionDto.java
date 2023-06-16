package carapuceogang.salamancacartelos.proposalsservice.dtos;

import java.util.Set;

public class DiscussionDto {
    private Long id;
    private Set<MessageDto> messages;
    private ProposalDto proposal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(Set<MessageDto> messages) {
        this.messages = messages;
    }

    public ProposalDto getProposal() {
        return proposal;
    }

    public void setProposal(ProposalDto proposal) {
        this.proposal = proposal;
    }
}
