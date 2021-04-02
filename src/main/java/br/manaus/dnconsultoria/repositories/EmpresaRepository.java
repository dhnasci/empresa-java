package br.manaus.dnconsultoria.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.manaus.dnconsultoria.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	
	@Transactional(readOnly = true)
	Empresa findOneByCnpj(String cpnj);

}
