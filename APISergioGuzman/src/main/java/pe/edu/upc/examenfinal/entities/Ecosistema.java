package pe.edu.upc.examenfinal.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ecosistema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String slganombre;
    String slgadescripcion;
    String slgazona;
    Date slgafechaCreacion;
    double slgamontoMantenimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "temperatura_id", nullable = false)
    Temperatura temperatura;
}
