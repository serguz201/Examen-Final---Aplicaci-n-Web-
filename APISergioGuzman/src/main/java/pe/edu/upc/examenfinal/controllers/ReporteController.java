package pe.edu.upc.examenfinal.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.examenfinal.dtos.Reporte1Dto;
import pe.edu.upc.examenfinal.entities.Ecosistema;
import pe.edu.upc.examenfinal.serviceimplements.EcosistemaService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Guzman/laptops")
public class ReporteController {
    final EcosistemaService slgaecoService;

    public ReporteController(EcosistemaService slgaecoService) {
        this.slgaecoService = slgaecoService;
    }

    @GetMapping
    public List<Ecosistema> get(){
        return slgaecoService.findAll();
    }

    @GetMapping("/reporte")
    public List<Reporte1Dto> getqueri1(){
        List<String[]> slgaresultados = slgaecoService.queri1();
        List<Reporte1Dto> slgareporte1dtos = new ArrayList<>();
        for (String[] resultado : slgaresultados){
            double slgavalor  = Double.parseDouble(resultado[0]);
            int slgacantidadEcosistema = Integer.parseInt(resultado[1]);
            Reporte1Dto slgadto = new Reporte1Dto(slgavalor, slgacantidadEcosistema);
            slgareporte1dtos.add(slgadto);
        }
        return slgareporte1dtos;
    }
}
