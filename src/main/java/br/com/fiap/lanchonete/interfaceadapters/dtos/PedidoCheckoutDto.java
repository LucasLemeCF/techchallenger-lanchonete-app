package br.com.fiap.lanchonete.interfaceadapters.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoCheckoutDto {

    private String pedidoId;

    public PedidoCheckoutDto(String pedidoId){
        this.pedidoId = pedidoId;
    }

}
