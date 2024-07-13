package br.com.fiap.lanchonete.core.usecases.services;

import br.com.fiap.lanchonete.interfaceadapters.dtos.PedidoDto;
import br.com.fiap.lanchonete.interfaceadapters.dtos.PedidoResponseDto;

import java.util.List;

public interface PedidoServicePort {
    PedidoResponseDto save(PedidoDto produtoDto);
    List<PedidoDto> findAll();
    List<PedidoResponseDto> findAllComProdutos();

}