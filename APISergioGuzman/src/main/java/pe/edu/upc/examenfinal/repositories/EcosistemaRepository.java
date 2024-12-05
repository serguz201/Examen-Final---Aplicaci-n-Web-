package pe.edu.upc.examenfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.examenfinal.entities.Ecosistema;

import java.util.List;

public interface EcosistemaRepository extends JpaRepository<Ecosistema, Integer> {
    //Queri  visualizar la cantidad de ecosistemas que tienen la misma temperatura para gestionarlas. -- Torta
    @Query(value = "SELECT  t.slgavalor, \n" +
            "       COUNT(e.id) AS cantidad_ecosistemas\n" +
            "FROM ecosistema e\n" +
            "JOIN temperatura t ON e.temperatura_id = t.id\n" +
            "GROUP BY  t.slgavalor", nativeQuery = true)
    public List<String[]> queri1();

}
