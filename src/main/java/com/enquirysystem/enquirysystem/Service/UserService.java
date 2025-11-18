package com.enquirysystem.enquirysystem.Service;

import com.enquirysystem.enquirysystem.Bindings.LoginForm;
import com.enquirysystem.enquirysystem.Bindings.SignupForm;
import com.enquirysystem.enquirysystem.Bindings.UnlockForm;

public interface UserService {

   public boolean signup(SignupForm form);
    
   public boolean unlockAccount(UnlockForm form);
   
   public String login(LoginForm form);

}
