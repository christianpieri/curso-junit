package br.ufsc.bridge.cursojunit.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.ufsc.bridge.cursojunit.model.form.ProfissionalForm;
import br.ufsc.bridge.cursojunit.utils.FormError;
import br.ufsc.bridge.cursojunit.utils.ProfissionalDataFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfissionalServiceTest {

	@Autowired
	private ProfissionalService serviceProf;

	@Autowired
	private UnidadeBasicaSaudeService serviceUbs;

	private ProfissionalForm form;
	private FormError erros;

	@Before
	public void setup() {
		this.form = ProfissionalDataFactory.createFullProfissional();
		this.erros = new FormError();
	}

	@Test
	public void testesAqui() {

	}

}
