package estacionamento.model;

import java.math.BigDecimal;

public class RelatorioAvaliacao {

    private BigDecimal media;
    private Long quantidadeAvaliacoes;

    public RelatorioAvaliacao(BigDecimal media, Long quantidadeAvaliacoes){
        this.media = media;
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }

    public BigDecimal getMedia(){
        return media;
    }

    public void setMedia(BigDecimal media){
        this.media = media;
    }

    public Long getQuantidadeAvaliacoes(){
        return quantidadeAvaliacoes;
    }

    public void setQuantidadeAvaliacoes(Long quantidadeAvaliacoes){
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }
}