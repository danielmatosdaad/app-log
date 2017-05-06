package br.app.log.servico.integracao;

import br.app.barramento.integracao.dto.DTO;

public class LogDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

}
