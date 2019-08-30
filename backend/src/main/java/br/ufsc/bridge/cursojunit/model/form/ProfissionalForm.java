package br.ufsc.bridge.cursojunit.model.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.joda.time.LocalDate;

import br.ufsc.bridge.cursojunit.utils.SexoEnum;

import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
@NoArgsConstructor
public class ProfissionalForm {

	private String cpfProfissional;
	private String cnsProfissional;
	private String nomeProfissional;
	private SexoEnum sexoProfissional;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dtNascProfissional;
	private String telefoneProfissional;
	private UnidadeBasicaSaudeForm ubsReferencia;

}
