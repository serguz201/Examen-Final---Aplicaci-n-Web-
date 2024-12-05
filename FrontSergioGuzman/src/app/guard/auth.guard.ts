import { CanActivateFn, Router } from '@angular/router';
import { LoginService } from '../service/login.service';
import { inject } from '@angular/core';

export const authGuard: CanActivateFn = (route, state) => {

 const lService = inject(LoginService);  
 const router = inject(Router);          

 const rpta = lService.verificar();      
 if (!rpta) {
   router.navigate(['/login-final-guzman']);        
   return false;
 }
 return rpta;
};
