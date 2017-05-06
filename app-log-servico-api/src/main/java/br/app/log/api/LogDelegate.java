package br.app.log.api;



import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.log.servico.integracao.IServicoLog;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class LogDelegate extends AbstractDelegate<IServicoLog> {

	public LogDelegate() {
	}
	public LogDelegate(LocalizadorServico<IServicoLog> localizaServico) {
		super(localizaServico);
	}

	public IServicoLog getServico() {
		return getLocalizadorServico().getServico();
	}

	public static LogDelegate getIntancia() {

		LocalizadorServico<IServicoLog> localizaServico = new LocalizarServicoLog<IServicoLog>(
				TipoLocalizador.REMOTO);

		LogDelegate delegate = new LogDelegate(localizaServico);

		return delegate;
	}
	
	
	@Override
	public LocalizadorServico<IServicoLog> getLocalizadorServico(TipoAcao acao) {

		if (TipoAcao.EXECUTAR.equals(acao)) {
			LocalizadorServico<IServicoLog> localizaServico = new LocalizarServicoLog<IServicoLog>(
					TipoLocalizador.REMOTO);

			return localizaServico;
		}
		throw new RuntimeException("Acao nao reconhecida");
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IServicoLog servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}
}
