package pe.edu.upc.examenfinal.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EcosistemaDto {
    Integer id;
    String slganombre;
    String slgadescripcion;
    String slgazona;
    Date slgafechaCreacion;
    Double slgamontoMantenimiento;

    Integer  user_id;
    Integer temperatura_id;
}
