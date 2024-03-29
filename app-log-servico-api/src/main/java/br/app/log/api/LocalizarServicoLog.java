package br.app.log.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

@SuppressWarnings("hiding")
public class LocalizarServicoLog<IServicoCatalago> extends AbstractLocalizadorServico<IServicoCatalago> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "remoto.catalago";
	private static final String REGISTRO_NOME_REMOTO = "local.catalago";

	public LocalizarServicoLog(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoLog() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
	}

}
