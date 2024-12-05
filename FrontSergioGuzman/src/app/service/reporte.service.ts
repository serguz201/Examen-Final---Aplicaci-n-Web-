import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reporte1Dto } from '../models/Reporte1Dto';

@Injectable({
  providedIn: 'root'
})
export class ReporteService {

  showUsername(): String {
    throw new Error('Method not implemented.');
  }
  private url = 'http://localhost:8080';

  constructor(private http: HttpClient) {}
  getQueri1(): Observable<Reporte1Dto[]> {
    let token = sessionStorage.getItem('token');
    return this.http.get<Reporte1Dto[]>(`${this.url}/Guzman/laptops/reporte`, {
      headers: new HttpHeaders()
        .set('Authorization', `Bearer ${token}`)
        .set('Content-Type', 'application/json'),
    })
  }
}
