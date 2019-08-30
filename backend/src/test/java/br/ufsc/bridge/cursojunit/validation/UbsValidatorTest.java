package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.bridge.cursojunit.model.form.UnidadeBasicaSaudeForm;
import br.ufsc.bridge.cursojunit.utils.FormError;

public class UbsValidatorTest {

	private UnidadeBasicaSaudeForm formUbs;
	private FormError erros;

	@Before
	public void setup() {
		this.formUbs = new UnidadeBasicaSaudeForm();
		this.erros = new FormError();
	}

	@Test
	public void testaSeNomeUbsEhObrigatorio() {

		this.formUbs.setNomeUbs("oi hoje eh um bom dia para nós fazermos um curso de teste automatizado");

		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);

		String erroNomeUbs = this.erros.getErrorList().get(0);
		String esperado = "Erro do tipo MALFORMED no campo nome ubs";

		Assert.assertEquals(esperado, erroNomeUbs);

	}

	@Test
	public void testaSeNomeUbsEhObrigatorio2() {

		this.formUbs.setNomeUbs("oi hoje eh um boom dia para nós fazermos um curso de teste automatizado");

		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);

		String erroNomeUbs = this.erros.getErrorList().get(0);
		String esperado = "Erro do tipo MALFORMED no campo nome ubs";

		Assert.assertEquals(esperado, erroNomeUbs);

	}

}
