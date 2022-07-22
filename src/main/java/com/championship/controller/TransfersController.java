package com.championship.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.championship.domain.dto.TransfersDTO;
import com.championship.domain.dto.TransfersRequestDTO;
import com.championship.domain.dto.TransfersResponseDTO;
import com.championship.domain.mapper.TransfersMapper;
import com.championship.domain.model.Transfers;
import com.championship.service.TransfersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "finalaws")

@RestController
@RequestMapping(value = "/transfers",  produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Utilizado para inserir, atualizar, deletar, listar e buscar uma Transferencia.")
public class TransfersController {

	@Autowired
	private TransfersService transfersService;
	
	@Autowired
	private final TransfersMapper transfersMapper = Mappers.getMapper(TransfersMapper.class);
	
	
	@PostMapping
	@ApiOperation(value = "Criar uma nova transferencia.")
	public ResponseEntity<TransfersResponseDTO> inserirTransferencia(@RequestBody TransfersRequestDTO dto){

		Transfers transfers = transfersMapper.transfersRequestDTOTOTransfers(dto);

		transfers = transfersService.salvar(transfers);
		TransfersResponseDTO playersResponseDTO = transfersMapper.transfersToTransfersResponseDTO(transfers);
		return ResponseEntity.ok(playersResponseDTO);
	}

	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar uma Transferencia.")
	public ResponseEntity<TransfersDTO> atualizarTransferenciaPorId(@PathVariable Long id, @RequestBody TransfersDTO dto){

		Transfers transfers = transfersService.buscarTransfersPorId(id);

		transfersMapper.updateEntity(dto, transfers);
		transfers = transfersService.salvar(transfers);
		TransfersDTO transfersDTO = transfersMapper.toDTO(transfers);

		return ResponseEntity.ok(transfersDTO);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar uma transferencia por ID.")
	public ResponseEntity<TransfersDTO> buscarTransferenciaPorId(@PathVariable Long id) {

		Transfers transfers = transfersService.buscarTransfersPorId(id);

		TransfersDTO transfersDTO = transfersMapper.toDTO(transfers);

		return ResponseEntity.ok(transfersDTO);
	}

	@GetMapping
	@ApiOperation(value = "Listar todos as Transferencia.")
	public ResponseEntity<List<TransfersResponseDTO>> listar() {
		List<TransfersResponseDTO> lsitaTransfersResponseDTO = transfersService.listarTransfers()
				.stream()
				.map(transfersMapper::transfersToTransfersResponseDTO)
				.collect(Collectors.toList());
		return ResponseEntity.ok(lsitaTransfersResponseDTO);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar Transferencia por ID.")
	public ResponseEntity<TransfersDTO> deletarTransferenciaPorId(@PathVariable Long id){

		Transfers transfers = transfersService.buscarTransfersPorId(id);
		transfersService.deletar(transfers);
		TransfersDTO transfersDTO = transfersMapper.toDTO(transfers);
		return ResponseEntity.ok(transfersDTO);
	}
	
}
