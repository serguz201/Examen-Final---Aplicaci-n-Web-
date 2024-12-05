import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ChartDataset, ChartOptions, ChartType } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import { ReporteService } from '../../service/reporte.service';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Reporte1Dto } from '../../models/Reporte1Dto';

@Component({
  selector: 'app-reporte01-guzman-alva',
  standalone: true,
  imports: [CommonModule,
    BaseChartDirective, MatTableModule,
    MatIconModule,
    RouterModule],
  templateUrl: './reporte01-guzman-alva.component.html',
  styleUrl: './reporte01-guzman-alva.component.css'
})
export class Reporte01GuzmanAlvaComponent implements  OnInit {

  dataSource:MatTableDataSource<Reporte1Dto>=new MatTableDataSource()
  displayedColumns:string[]=['slgavalor','slgacantidadEcosistema']

  barChartOptions: ChartOptions = {
    responsive: true,
    scales: {
      x: { beginAtZero: true },
      y: { beginAtZero: true }
    }
  };
  barChartLabels: string[] = [];
  barChartType: ChartType = 'pie';
  barChartLegend = true;
  barChartData: ChartDataset[] = [];


  constructor(private r: ReporteService) {}

  ngOnInit(): void {
    this.r.getQueri1().subscribe((data) => {  
      this.barChartLabels = data.map((item) => item.slgavalor.toString()); 
      this.barChartData = [
        {
          data: data.map((item) => item.slgacantidadEcosistema),
          label: 'Número ',
          backgroundColor: 'rgba(33, 150, 243, 0.5)',  
          borderColor: 'rgba(33, 150, 243, 1)',     
          borderWidth: 1  
        }
      ];
      this.dataSource = new MatTableDataSource(data); 
    });
  }

}
