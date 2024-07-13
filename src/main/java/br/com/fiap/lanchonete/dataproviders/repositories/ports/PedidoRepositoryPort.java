package br.com.fiap.lanchonete.dataproviders.repositories.ports;

import br.com.fiap.lanchonete.interfaceadapters.dtos.PedidoDto;
import br.com.fiap.lanchonete.interfaceadapters.dtos.PedidoResponseDto;

import java.util.List;

public interface PedidoRepositoryPort {
    PedidoResponseDto save(PedidoDto pedidoDto); // Create and Update
    List<PedidoDto> findAll(); // Read All
    List<PedidoResponseDto> findAllComProdutos(); // le todos, trazendo os produtos
}