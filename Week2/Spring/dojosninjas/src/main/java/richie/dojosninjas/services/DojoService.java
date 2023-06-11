package richie.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import richie.dojosninjas.models.Dojo;
import richie.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

    @Autowired DojoRepository dojoRepository;

    public void createDojo(Dojo dojo) {
        dojoRepository.save(dojo);
    }

    public List<Dojo> getAllDojos() {
        return dojoRepository.findAll();
    }

    public Dojo getOneDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        return optionalDojo.orElse(null);
    }
    
}
