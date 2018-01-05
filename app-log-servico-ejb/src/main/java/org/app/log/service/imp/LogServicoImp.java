package org.app.log.service.imp;

import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.app.barramento.infra.persistencia.dao.IFacedeDAO;
import br.app.barramento.infra.persistencia.service.ServiceDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoLocalDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.log.dao.LogFacede;
import br.app.log.dao.model.Log;
import br.app.log.servico.integracao.IServicoLogLocal;
import br.app.log.servico.integracao.IServicoLogRemote;
import br.app.log.servico.integracao.LogDTO;

@Stateless
@Remote(value = { IServicoLogRemote.class, IServicoRemoteDAO.class })
@Local(value = { IServicoLogLocal.class, IServicoLocalDAO.class })
public class LogServicoImp
		implements IServicoLogRemote, IServicoLogLocal, IServicoLocalDAO<LogDTO>, IServicoRemoteDAO<LogDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private LogFacede logFacade;

	@Override
	public LogDTO adiconar(LogDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.adiconar(getLogFacade(), Log.class, dto);

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<LogDTO> adiconar(List<LogDTO> listaDto) throws InfraEstruturaException, NegocioException {
		try {

			for (LogDTO dto : listaDto) {

				adiconar(dto);
			}

			return listaDto;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public LogDTO alterar(LogDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.alterar(getLogFacade(), Log.class, dto);
			return dto;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public void remover(LogDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(getLogFacade(), Log.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}

	}

	@Override
	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
	}

	@Override
	public List<LogDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {

			return (List<LogDTO>) ServiceDAO.bustarTodos(this.getLogFacade(), LogDTO.class);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public LogDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorID(this.getLogFacade(), LogDTO.class, id);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public List<LogDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorIntervaloID(getLogFacade(), LogDTO.class, range);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public IFacedeDAO getLogFacade() {
		return logFacade;
	}


	@Asynchronous
	@Override
	public void registrarLog(LogDTO log) throws InfraEstruturaException, NegocioException {
		// TODO Auto-generated method stub
		
	}

}
