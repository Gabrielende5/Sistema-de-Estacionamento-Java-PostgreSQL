package estacionamento.repository;

import estacionamento.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

    //Para proibir que um id_reserva tenha vários id_pagamento, algo que não tem lógica considerando que a pessoa vai pagar diretamente o custo daquela reserva
    boolean existsByReservaIdReserva(Integer idReserva);
}
