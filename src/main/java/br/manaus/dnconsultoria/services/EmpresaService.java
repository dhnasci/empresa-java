package br.manaus.dnconsultoria.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.manaus.dnconsultoria.domain.Empresa;
import br.manaus.dnconsultoria.repositories.EmpresaRepository;
import br.manaus.dnconsultoria.services.exceptions.ObjectNotFoundException;


@Service
public class EmpresaService {
	
	private Logger log = LoggerFactory.getLogger(EmpresaService.class);
	
	@Autowired EmpresaRepository repo;
	
	public Empresa find(Integer id) {
		Optional<Empresa> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException("Empresa nao encontrada id: "
				+ id + "!")
				);
	}
	
	public List<Empresa> listar() {
		
		return repo.findAll();
	}

	public Empresa insert(Empresa obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Empresa update(Empresa obj) {
		return repo.save(obj);
	}

	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			log.error("Erro ao apagar empresa: " + e.getMessage());
		}
		
	}

}
