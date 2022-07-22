package com.championship.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.championship.domain.model.Transfers;
import com.championship.repository.TransfersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TransfersService")
public class TransfersServiceImpl implements TransfersService {

	@Autowired
	private TransfersRepository transfersRepository;
	
	@Autowired
	private TeamsService teamsService;

	
	@Override
	public Transfers salvar(Transfers transfers) {
		
		buscarTimes(transfers);

		return transfersRepository.save(transfers);
	}


	@Override
	public void deletar(Transfers transfers) {
		transfersRepository.delete(transfers);
	}
	
	@Override
	public void deletarPorId(Long id) {
		transfersRepository.deleteById(id);		
	}

	@Override
	public List<Transfers> listarTransfers() {
		
		List<Transfers> list = transfersRepository.findAll();
		
		if(list.isEmpty())
			throw new EntityNotFoundException("Nenhuma transferencia registrada.");
		
		return list;
	}

	@Override
	public Transfers buscarTransfersPorId(Long id) {
		Optional<Transfers> transferencia = transfersRepository.findById(id);
		return transferencia.orElseThrow(() -> new EntityNotFoundException("ID transferencia não encontrado."));
	}

	private void buscarTimes(Transfers transfers) {
		var timeOrigem = teamsService.buscarTeamsPorNome(transfers.getTimeOrigem().getNome());
		var timeDestino = teamsService.buscarTeamsPorNome(transfers.getTimeDestino().getNome());
		
		transfers.setTimeOrigem(timeOrigem);
		transfers.setTimeDestino(timeDestino);
	}

}
