package com.devsuperior.uri2737;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import com.devsuperior.uri2737.repositories.LawyerRepository;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {

	@Autowired
	private LawyerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2737Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<LawyerMinProjection> list1 = repository.searchSQL();
		
		List<LawyerMinDTO> result1 = list1.stream().map(law -> new LawyerMinDTO(law)).collect(Collectors.toList());
		
		System.out.println("\nCONSULTAS COM SQL RAIZ\n");
		for(LawyerMinDTO consultSQL : result1) {
			System.out.println(consultSQL);
		}
		
		List<LawyerMinProjection> list2 = repository.searchSQL02();		
		List<LawyerMinDTO> result2 = list2.stream().map(law -> new LawyerMinDTO(law)).collect(Collectors.toList());		
	
		for(LawyerMinDTO consultSQL : result2) {
			System.out.println(consultSQL);
		}
		
		List<LawyerMinProjection> list3 = repository.searchSQL03();		
		List<LawyerMinDTO> result3 = list3.stream().map(law -> new LawyerMinDTO(law)).collect(Collectors.toList());		
	
		for(LawyerMinDTO SQLAlternativo : result3) {
			System.out.println(SQLAlternativo);
		}
		

	}
}
