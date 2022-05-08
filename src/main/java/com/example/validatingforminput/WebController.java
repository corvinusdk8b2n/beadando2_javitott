package com.example.validatingforminput;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Optional;


@Controller
public class WebController implements WebMvcConfigurer
{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(PersonForm personForm)
	{
		return "form";
	}


	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			return "form";
		}

		boolean personIsRegistered = userRepository.findByUsername(personForm.getUsername()).isPresent();
		System.out.println(personIsRegistered);
		if(!personIsRegistered)
		{
			Person person = new Person();
			person.setLastname(personForm.getLastname());
			person.setFirstname(personForm.getFirstname());
			person.setUsername(personForm.getUsername());

			String password = personForm.getPassword();
			StringBuilder titkos = new StringBuilder();

			for (int i = 0; i < password.length(); i++)
			{
				int ascii = password.charAt(i);
				ascii++;
				char ch = (char) ascii;
				titkos.append(ch);
			}
			person.setPassword(titkos.toString());

			userRepository.save(person);

			return "redirect:/results";
		}
		else
		{
			return "form";
		}
	}

	@PostMapping("/login")
	private String showLoginPage()
	{
		return "login";
	}

	@PostMapping("/welcome")
	private String showWelcomePage(@RequestParam() String username, String password)
	{
		System.out.println(username + " " + password);
		Optional<Person> foundUser = userRepository.findByUsername(username);
		System.out.println("User is found");
		Person person;

		if(foundUser.isPresent())
		{
			System.out.println("User is present");
			person = foundUser.get();
			System.out.println(person.getPassword());
			StringBuilder titkos = new StringBuilder();

			for (int i = 0; i < password.length(); i++)
			{
				int ascii = password.charAt(i);
				ascii++;
				char ch = (char) ascii;
				titkos.append(ch);
			}
			password = titkos.toString();

			if(person.getPassword().equals(password))
			{
				System.out.println("passwords match");
				return "results";
			}
			else
			{
				return "login";
			}
		}
		else
		{
			return "login";
		}
	}
}
