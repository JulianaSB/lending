package br.com.juliana.lending;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.juliana.lending.dto.Person;
import br.com.juliana.lending.dto.Lending;
import br.com.juliana.lending.dto.RequestBodyLending;
import br.com.juliana.lending.enumerations.LendingType;
import br.com.juliana.lending.service.LendingService;

@ExtendWith(SpringExtension.class)
class LendingApplicationTests {
	RequestBodyLending requestBodyLending;
	LendingService lendingService;
	List<Lending> lendingList; 

	@BeforeEach
	void setup() {
		Person person = new Person();
		person.setCpf("123.456.789-10");
		person.setNome("teste teste");
		person.setIdade(29);
		person.setUf("SP");
		person.setRenda_mensal(3000);
		requestBodyLending = new RequestBodyLending(person);
		lendingService = new LendingService();
		lendingList = new ArrayList<>();
		lendingList.add(new Lending(LendingType.EMPRESTIMO_PESSOAL));
		lendingList.add(new Lending(LendingType.EMPRESTIMO_GARANTIA));
	}

	@Test
	void testNewLending() {
		List<Lending> result = lendingService.lendingOptions(requestBodyLending.getCliente()).getProdutos_emprestimo();
		assertEquals(lendingList, result);
	}

}
