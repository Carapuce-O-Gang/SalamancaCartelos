package carapuceogang.salamancacartelos.proposalsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carapuceogang.salamancacartelos.proposalsservice.dtos.DiscussDto;
import carapuceogang.salamancacartelos.proposalsservice.models.Discuss;
import carapuceogang.salamancacartelos.proposalsservice.repositories.DiscussRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussService {
    @Autowired
    DiscussRepository discussRepository;

    public List<Discuss> getDiscussions() {
        return discussRepository.findAll();
    }

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
}
