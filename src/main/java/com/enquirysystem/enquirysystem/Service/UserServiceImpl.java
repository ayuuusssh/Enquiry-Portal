package com.enquirysystem.enquirysystem.Service;

import com.enquirysystem.enquirysystem.Bindings.SignupForm;
import com.enquirysystem.enquirysystem.Entity.User_Details;
import com.enquirysystem.enquirysystem.Repository.UserDetailsRepo;
import com.enquirysystem.enquirysystem.Utils.EmailUtils;
import com.enquirysystem.enquirysystem.Utils.PwdUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDetailsRepo userDetailsRepo;
	@Autowired
	private EmailUtils emailUtils;
 
    @Override
    public boolean signup(SignupForm form) {
    	
    	User_Details user = userDetailsRepo.findByEmail(form.getEmail());
    	if(user!=null) {
    		return false;
    	}

        User_Details entity = new User_Details();
        BeanUtils.copyProperties(form,entity);
        String tempPwd = PwdUtils.generateRandomPwd();
        
        
        entity.setPwd(tempPwd);
        entity.setAccountStatus("Locked");

        userDetailsRepo.save(entity);
        
        String to = form.getEmail();
        String subject = "Write Your Subject Here";
       StringBuffer body = new StringBuffer();
       body.append("<h1>Use Below password to unlcok your account</h1>");
       body.append("Temperary Password : " + tempPwd); 
       body.append("<a href = \"http://localhost:8080/unlock?email="+to+"\">Click here to unlock you account</a>");
        
        emailUtils.sendMail(to, subject, body.toString());

        return true;
    }
}
