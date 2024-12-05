import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { Routes } from '@angular/router';
import { LoginGuzmanAlvaComponent } from './app/components/login-guzman-alva/login-guzman-alva.component';
import { authGuard } from './app/guard/auth.guard';
import { HomeGuzmanAlvaComponent } from './app/components/home-guzman-alva/home-guzman-alva.component';
import { Reporte01GuzmanAlvaComponent } from './app/components/reporte01-guzman-alva/reporte01-guzman-alva.component';
import { provideRouter, RouterModule } from '@angular/router';
import { importProvidersFrom } from '@angular/core';
import { HttpClientModule, provideHttpClient } from '@angular/common/http';
import { provideCharts, withDefaultRegisterables } from 'ng2-charts';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login-final-guzman',
    pathMatch: 'full'
  },
  {
    path: 'login-final-guzman',
    component: LoginGuzmanAlvaComponent
  },
  {
    path: 'components',
    canActivate: [authGuard],
    children: [
      {
        path: 'home-Alva',
        component: HomeGuzmanAlvaComponent
      },
      {
        path: 'reporte01-sergio-leandro',
        component: Reporte01GuzmanAlvaComponent
      },
    ]
  }
];

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes),
    importProvidersFrom(HttpClientModule,RouterModule, MatToolbarModule, BrowserAnimationsModule),
    provideHttpClient(),
    provideCharts(withDefaultRegisterables())
  ],
}).catch(err => console.error(err));
