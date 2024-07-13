package br.com.fiap.lanchonete.interfaceadapters.controllers;


import java.util.List;


import br.com.fiap.lanchonete.infrastructure.exceptions.RegraNegocioException;
import br.com.fiap.lanchonete.core.usecases.services.PedidoServicePort;
import br.com.fiap.lanchonete.core.usecases.services.impl.PedidoServiceImpl;
import br.com.fiap.lanchonete.interfaceadapters.dtos.PedidoDto;
import br.com.fiap.lanchonete.interfaceadapters.dtos.PedidoResponseDto;
import br.com.fiap.lanchonete.dataproviders.repositories.ports.ClienteRepositoryPort;
import br.com.fiap.lanchonete.dataproviders.repositories.ports.PedidoRepositoryPort;
import br.com.fiap.lanchonete.dataproviders.repositories.ports.ProdutoRepositoryPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lanchonete/v1/pedidos")
@Tag(name = "Pedidos", description = "Pedidos de clientes")
public class PedidoController {

    private final PedidoServicePort pedidoService;
    private PedidoController(PedidoRepositoryPort pedidoRepository, ClienteRepositoryPort clienteRepository, ProdutoRepositoryPort produtoRepository) {
        this.pedidoService = new PedidoServiceImpl(pedidoRepository, clienteRepository, produtoRepository);
    }

    @PostMapping
    @Operation(description = "Gera o pedido do cliente")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = PedidoDto.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    public ResponseEntity<?> createPedidos(@RequestBody PedidoDto pedidoDto) {
        try{
            PedidoResponseDto savedPedido = pedidoService.save(pedidoDto);
            return ResponseEntity.ok(savedPedido);
        }catch(RegraNegocioException rne){
            return ResponseEntity.badRequest().body(rne.getMessage());
        }
    }
    @GetMapping
    @Operation(description = "Lista todos os pedidos")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = PedidoResponseDto.class)))
    public ResponseEntity<List<PedidoResponseDto>> getAllPedidos() {
        List<PedidoResponseDto> pedidos = pedidoService.findAllComProdutos();
        return ResponseEntity.ok(pedidos);
    }

}
