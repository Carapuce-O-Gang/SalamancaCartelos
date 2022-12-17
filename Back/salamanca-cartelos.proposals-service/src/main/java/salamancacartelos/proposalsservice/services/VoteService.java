package salamancacartelos.proposalsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salamancacartelos.proposalsservice.dtos.VoteDto;
import salamancacartelos.proposalsservice.models.Vote;
import salamancacartelos.proposalsservice.repositories.VoteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {
    @Autowired
    VoteRepository voteRepository;

    public List<Vote> getVotes() {
        return voteRepository.findAll();
    }

    public Vote getVote(Long id) throws Exception {
        Optional<Vote> vote = voteRepository.findById(id);

        if(vote.isEmpty()) {
            throw new Exception("vote not found");
        }

        return vote.get();
    }

    public Vote createVote(VoteDto voteDto) throws Exception {
        if (voteDto.getUserId() != null && voteRepository.existsByUserId(voteDto.getUserId())) {
            throw new Exception("vote user already exist");
        }

        Vote vote = new Vote();
        vote.setUserId(voteDto.getUserId());
        vote.setVoted(voteDto.getVoted());

        return voteRepository.save(vote);
    }

    public Vote updateVote(Long id, VoteDto voteDto) throws Exception {
        if (!voteRepository.existsById(id)) {
            throw new Exception("vote doesn't exist");
        }

        Optional<Vote> p = voteRepository.findById(id);

        if (p.isEmpty()) {
            throw new Exception("vote doesn't exist");
        }

        Vote vote = p.get();
        vote.setUserId(voteDto.getUserId());
        vote.setVoted(voteDto.getVoted());

        return voteRepository.save(vote);
    }

    public void deleteVote(Long id) {
        voteRepository.deleteById(id);
    }
}
