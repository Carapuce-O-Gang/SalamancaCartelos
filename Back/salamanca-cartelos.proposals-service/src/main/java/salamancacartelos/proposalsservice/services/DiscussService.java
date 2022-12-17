package salamancacartelos.proposalsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======
import salamancacartelos.proposalsservice.dtos.DiscussDto;
import salamancacartelos.proposalsservice.dtos.ProposalDto;
>>>>>>> develop
import salamancacartelos.proposalsservice.models.Discuss;
import salamancacartelos.proposalsservice.models.Proposal;
import salamancacartelos.proposalsservice.repositories.DiscussRepository;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> develop

@Service
public class DiscussService {
    @Autowired
    DiscussRepository discussRepository;

    public List<Discuss> getDiscussions() {
        return discussRepository.findAll();
    }
<<<<<<< HEAD
=======

    public Discuss getDiscuss(Long id) throws Exception {
        Optional<Discuss> discuss = discussRepository.findById(id);

        if(discuss.isEmpty()) {
            throw new Exception("discuss not found");
        }

        return discuss.get();
    }

    public Discuss createDiscuss(DiscussDto discussDto) throws Exception {
        Discuss discuss = new Discuss();
        discuss.setUserId(discussDto.getUserId());
        discuss.setMessage(discussDto.getMessage());

        return discussRepository.save(discuss);
    }
>>>>>>> develop
}
