package com.api.sexshop.services;

import com.api.sexshop.entities.PedidoEntity;
import com.api.sexshop.repositories.PedidosRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    private PedidosRepository pedidosRepository;

    public PedidoService() {

    }

    //(GET){READ - ALL}
    public List<PedidoEntity> getPedidos() {
        List<PedidoEntity> pedidos = pedidosRepository.findAll();
        return pedidos;
    }

    //(GET){READ - ID}
    public Optional<PedidoEntity> getPedidoById(UUID id) {
        Optional<PedidoEntity> pedidoFound = pedidosRepository.findById(id);
        if(pedidoFound.isPresent()) {
            return pedidoFound;
        }else{
            return Optional.empty();
        }
    }

    //(POST){CREATE}
    public String createPedido(PedidoEntity pedido) {
        pedido.setId(UUID.randomUUID());
        if (pedidosRepository.existsById(pedido.getId())) {
            return "Ese pedido ya existe";
        }else {
            pedidosRepository.save(pedido);
            return "Pedido creado con exito";
        }
    }

    //(PUT){UPDATE}
    public String updatePedido(UUID id, PedidoEntity pedido) {
        Optional<PedidoEntity> pedidoFound = getPedidoById(id);
        if(pedidoFound.isPresent()) {
            pedidosRepository.save(pedido);
            return "Pedido actualizado con exito";
        }else {
            return "Pedido no encontrado";
        }
    }

    //(DELETE){DELETE}
    public String deletePedido(UUID id) {
        Optional<PedidoEntity> pedidoFound = getPedidoById(id);
        if(pedidoFound.isPresent()) {
            pedidosRepository.delete(pedidoFound.get());
            return "Pedido eliminado con exito";
        }else{
            return "Pedido no encontrado";
        }
    }
}
