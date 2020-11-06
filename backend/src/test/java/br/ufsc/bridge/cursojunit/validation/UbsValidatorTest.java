package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.ufsc.bridge.cursojunit.model.form.UnidadeBasicaSaudeForm;
import br.ufsc.bridge.cursojunit.utils.ErrosEnum;
import br.ufsc.bridge.cursojunit.utils.FormError;

public class UbsValidatorTest {

	@Test
	public void verificaSeFormularioSemNomeDeUbsTemErroDentroDaLista() {
		UnidadeBasicaSaudeForm form = new UnidadeBasicaSaudeForm();
		FormError formDeErros = new FormError();
		form.setNomeUbs(null);

		UnidadeBasicaSaudeValidator.validate(form, formDeErros);
		boolean temErros = formDeErros.getErrorList().size() > 0;

		Assert.assertTrue(temErros);
	}

	@Test
	public void verificaMensagemQueListaDeErrosContemQuandoNomeUbsEhNulo() {
		UnidadeBasicaSaudeForm form = new UnidadeBasicaSaudeForm();
		FormError formDeErros = new FormError();
		form.setNomeUbs("");
		String erro = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo nome ubs";

		UnidadeBasicaSaudeValidator.validate(form, formDeErros);

		Assert.assertEquals(erro, formDeErros.getErrorList().get(0));
	}

	@Test
	public void verificaSeNomeUbsEhFormadoApenasPorLetrasFeliz() {
		UnidadeBasicaSaudeForm form = new UnidadeBasicaSaudeForm();
		FormError formDeErros = new FormError();
		form.setNomeUbs("CS Trindade");

		UnidadeBasicaSaudeValidator.validate(form, formDeErros);

		boolean temErros = formDeErros.getErrorList().size() > 0;

		Assert.assertFalse(temErros);
	}

	@Ignore
	@Test
	public void verificaSeNomeUbsEhFormadoApenasPorLetrasENaoDeixaCaracterEspecial() {
		UnidadeBasicaSaudeForm form = new UnidadeBasicaSaudeForm();
		FormError formDeErros = new FormError();
		form.setNomeUbs("CS Trin87987de");

		UnidadeBasicaSaudeValidator.validate(form, formDeErros);

		boolean temErros = formDeErros.getErrorList().size() > 0;

		Assert.assertTrue(temErros);
	}

	@Test
	public void verificaSeUnidadeDeSaudeComNomeCom69CaracteresEhAceito() {
		UnidadeBasicaSaudeForm form = new UnidadeBasicaSaudeForm();
		FormError formDeErros = new FormError();
		form.setNomeUbs("Centro de Saude Caracteres Quantos Caracteres Pode Ter Uma Unidade De");

		UnidadeBasicaSaudeValidator.validate(form, formDeErros);

		boolean temErros = formDeErros.getErrorList().size() > 0;

		Assert.assertFalse(temErros);
	}

	@Test
	public void verificaSeUnidadeDeSaudeComNomeCom70CaracteresEhAceito() {
		UnidadeBasicaSaudeForm form = new UnidadeBasicaSaudeForm();
		FormError formDeErros = new FormError();
		form.setNomeUbs("Centro de Saude Caracteres Quantos Caracteres Pode Ter Uma Unidade DeS");

		UnidadeBasicaSaudeValidator.validate(form, formDeErros);

		boolean temErros = formDeErros.getErrorList().size() > 0;

		Assert.assertFalse(temErros);
	}

	@Test
	public void verificaSeUnidadeDeSaudeComNomeCom71CaracteresEhInvalido() {
		UnidadeBasicaSaudeForm form = new UnidadeBasicaSaudeForm();
		FormError formDeErros = new FormError();
		form.setNomeUbs("Centro de Saude Caracteres Quantos Caracteres Pode Ter Uma Unidade DeUb");

		UnidadeBasicaSaudeValidator.validate(form, formDeErros);

		boolean temErros = formDeErros.getErrorList().size() == 1;

		Assert.assertTrue(temErros);
	}

	@Test
	public void verificaMsgDeErroUbsComNomeComMaisDe70Caracteres() {
		UnidadeBasicaSaudeForm form = new UnidadeBasicaSaudeForm();
		FormError formDeErros = new FormError();
		form.setNomeUbs("Centro de Saude Caracteres Quantos Caracteres Pode Ter Uma Unidade DeUb");

		String erro = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo nome ubs";

		UnidadeBasicaSaudeValidator.validate(form, formDeErros);

		Assert.assertEquals(erro, formDeErros.getErrorList().get(0));
	}

}
