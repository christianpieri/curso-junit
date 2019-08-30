package br.ufsc.bridge.cursojunit.utils;

import org.joda.time.LocalDate;

import br.ufsc.bridge.cursojunit.model.form.ProfissionalForm;
import br.ufsc.bridge.cursojunit.model.form.UnidadeBasicaSaudeForm;

public class ProfissionalDataFactory {

	public static ProfissionalForm createFullProfissional() {

		ProfissionalForm form = new ProfissionalForm();

		form.setCnsProfissional("900000000000008");
		form.setCpfProfissional("09904505977");
		form.setDtNascProfissional(new LocalDate(1995, 4, 12));
		form.setNomeProfissional("Christian Pieri");
		form.setSexoProfissional(SexoEnum.MASCULINO);
		form.setTelefoneProfissional("(048)988521222");

		UnidadeBasicaSaudeForm ubsForm = new UnidadeBasicaSaudeForm();
		ubsForm.setNomeUbs("CS Trindade");
		form.setUbsReferencia(ubsForm);

		return form;

	}

}
