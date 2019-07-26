package br.ufsc.bridge.cursojunit.validation;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import br.ufsc.bridge.cursojunit.model.form.ProfissionalForm;
import br.ufsc.bridge.cursojunit.utils.ErrosEnum;
import br.ufsc.bridge.cursojunit.utils.FormError;

public class ProfissionalFormValidator {

	public static void validate(ProfissionalForm form, FormError erros) {

		if (StringUtils.isBlank(form.getCpfProfissional())) {
			erros.add(ErrosEnum.REQUIRED, "cpf profissional");
		} else if (!CpfValidator.isCPF(form.getCpfProfissional())) {
			erros.add(ErrosEnum.MALFORMED, "cpf profissional");
		}

		if (StringUtils.isBlank(form.getCnsProfissional())) {
			erros.add(ErrosEnum.REQUIRED, "cns profissional");
		} else if (!CnsValidator.isValid(form.getCnsProfissional())) {
			erros.add(ErrosEnum.MALFORMED, "cns profissional");
		}

		if (StringUtils.isBlank(form.getNomeProfissional())) {
			erros.add(ErrosEnum.REQUIRED, "nome profissional");
		}

		if (form.getSexoProfissional() == null) {
			erros.add(ErrosEnum.REQUIRED, "sexo profissional");
		}

		if (form.getDtNascProfissional() != null && form.getDtNascProfissional().isAfter(LocalDate.now())) {
			erros.add(ErrosEnum.DATA_POSTERIOR_ATUAL, "data de nascimento do profissional");
		}

		if (form.getUbsReferencia() == null || StringUtils.isBlank(form.getUbsReferencia().getNomeUbs())) {
			erros.add(ErrosEnum.REQUIRED, "profissional precisa estar alocado a uma ubs");
		}

	}

}
