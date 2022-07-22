package com.championship.service;

import com.championship.domain.model.Transfers;

import java.util.List;


public interface TransfersService {

	Transfers salvar(Transfers transfers);
	void deletar(Transfers transfers);
	void deletarPorId(Long id);
	List<Transfers> listarTransfers();
	Transfers buscarTransfersPorId(Long id);
	
}
