package pe.edu.upc.examenfinal.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Temperatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    double slgavalor;
    double slgalatitud;
    double slgalongitud;
}
