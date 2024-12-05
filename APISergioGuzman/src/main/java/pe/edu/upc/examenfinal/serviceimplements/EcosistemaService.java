package pe.edu.upc.examenfinal.serviceimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.examenfinal.entities.Ecosistema;
import pe.edu.upc.examenfinal.repositories.EcosistemaRepository;
import pe.edu.upc.examenfinal.repositories.UserRepository;

import java.util.List;

@Service
public class EcosistemaService {
    final EcosistemaRepository slgaecosistemaRepository;
    final UserRepository slgauserRepository;

    public EcosistemaService(EcosistemaRepository ecosistemaRepository, UserRepository userRepository) {
        this.slgaecosistemaRepository = ecosistemaRepository;
        this.slgauserRepository = userRepository;
    }

    public List<Ecosistema> findAll() {
        return slgaecosistemaRepository.findAll();
    }

    public List<String[]> queri1(){
        return slgaecosistemaRepository.queri1();
    }

}
