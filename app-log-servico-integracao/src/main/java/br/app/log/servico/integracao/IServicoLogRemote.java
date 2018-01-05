package br.app.log.servico.integracao;

import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;

public interface IServicoLogRemote extends IServicoLog<LogDTO> {

	public void registrarLog(LogDTO log) throws InfraEstruturaException, NegocioException;
}
