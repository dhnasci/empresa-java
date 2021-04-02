package br.manaus.dnconsultoria.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.manaus.dnconsultoria.domain.Empresa;
import br.manaus.dnconsultoria.repositories.EmpresaRepository;

@Service
public class DBService {
	
	@Autowired 
	EmpresaRepository repo;
	
	public void instantiateTestDatabase() {
		
		Empresa emp1 = new Empresa(1, "PETROBRAS", "23.355.878/0001-34", "Av Darci Vargas 200, Chapada - Manaus - AM", "admin@petrobras.com.br");
		Empresa emp2 = new Empresa(2, "DISTRIBUIDORA SHELL", "52.465.127/0001-67", "Av Theomario Pinto 1350, D Pedro - Manaus - AM", "comercial@shell.com.br");
		repo.saveAll(Arrays.asList(emp1, emp2));
		
	}
	

}
