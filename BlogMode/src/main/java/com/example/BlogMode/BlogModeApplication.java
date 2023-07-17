package com.example.BlogMode;

import com.example.BlogMode.config.AppConstant;
import com.example.BlogMode.model.Role;
import com.example.BlogMode.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BlogModeApplication implements CommandLineRunner {

	@Autowired
	private  PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {

		SpringApplication.run(BlogModeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(passwordEncoder.encode("123"));

		try {

			Role role=new Role();
			role.setId(AppConstant.ADMIN_USER);
			role.setName("ADMIN_USER");

			Role role1=new Role();
			role1.setId(AppConstant.NORMAL_USER);
			role1.setName("NORMAL_USER");

			List<Role> roles = List.of(role, role1);
			List<Role> roleList = roleRepo.saveAll(roles);

			roleList.forEach(
					r->
					{
						System.out.println(r.getName() + "  " + r.getId());
					}
			);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
