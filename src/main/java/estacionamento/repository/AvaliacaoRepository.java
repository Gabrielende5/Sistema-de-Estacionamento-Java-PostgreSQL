package estacionamento.repository;

import estacionamento.model.Avaliacao;
import estacionamento.model.RelatorioAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Integer> {

    //NativeQuery para avaliação
    @Query(value = """
    SELECT ROUND(AVG(nota), 2), COUNT(nota)
    FROM avaliacao
    """, nativeQuery = true)
    RelatorioAvaliacao buscarMediaAvaliacoes();

}
