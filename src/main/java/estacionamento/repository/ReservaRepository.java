package estacionamento.repository;

import estacionamento.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    //Parte do NativeQuery
    @Query(value = """
                SELECT usuario.id_usuario, usuario.nome, COUNT(reserva.id_reserva) as quantidade_reservas, SUM(reserva.valor_total) as valor_gasto
                FROM usuario
                JOIN reserva
                ON usuario.id_usuario = reserva.id_usuario
                GROUP BY usuario.id_usuario, usuario.nome
                """, nativeQuery = true)
    List<Object[]> buscarRelatorio();
}
