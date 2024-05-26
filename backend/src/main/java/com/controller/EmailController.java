package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.model.EmailResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.EmailRequest;
import com.service.EmailService;

@RestController
@CrossOrigin
public class EmailController 
{
	@Autowired
    private EmailService emailService; // Inject the EmailService
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "Hello!! this is my email API";
	}
	
	//api to send mail
	@RequestMapping(value = "/sendmail", method = RequestMethod.POST)
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
	{
		
		System.out.println(request);
		boolean result = this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
		if(result)
		{
			return ResponseEntity.ok(new EmailResponse("Email sent successfully..!!"));

		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email Not Sent..!"));

		}
		
	}	
		

}
