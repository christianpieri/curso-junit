package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.bridge.cursojunit.model.form.ProfissionalForm;
import br.ufsc.bridge.cursojunit.utils.FormError;
import br.ufsc.bridge.cursojunit.utils.ProfissionalDataFactory;

public class ProfissionalValidatorTest {

	private ProfissionalForm form;
	private FormError erros;

	@Before
	public void setup() {
		this.form = ProfissionalDataFactory.createFullProfissional();
		this.erros = new FormError();
	}

	@Test
	public void testeValidadorAceitaProfissionalCompleto() {
		ProfissionalFormValidator.validate(this.form, this.erros);

		Assert.assertEquals(0, this.erros.getErrorList().size());
	}

	@Test
	public void testeValidadorPegaNomeNulo() {
		this.form.setNomeProfissional(null);

		ProfissionalFormValidator.validate(this.form, this.erros);

		Assert.assertEquals(1, this.erros.getErrorList().size());
	}

	@Test
	public void testeValidadorPegaNomeVazio() {
		this.form.setNomeProfissional("");

		ProfissionalFormValidator.validate(this.form, this.erros);

		Assert.assertEquals(1, this.erros.getErrorList().size());
	}

	@Test
	public void validadorDeveAceitarSomenteLetrasNoNomeDoProfissional() {
		this.form.setNomeProfissional("!@#$%*()54");

		ProfissionalFormValidator.validate(this.form, this.erros);

		Assert.assertEquals(1, this.erros.getErrorList().size());
	}

	@Test
	public void verificaNumeroMaximoDeCaracteresNomeProfissional() {
		this.form.setNomeProfissional("oi hoje eh um bom dia para nós fazermos um curso de teste automatizado");

		ProfissionalFormValidator.validate(this.form, this.erros);

		Assert.assertEquals(0, this.erros.getErrorList().size());
	}

}
