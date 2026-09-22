package estacionamento.model;

import java.math.BigDecimal;

public class RelatorioAvaliacao {

    private BigDecimal media;
    private Long quantidade;

    public RelatorioAvaliacao(BigDecimal media, Long quantidade){
        this.media = media;
        this.quantidade = quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public BigDecimal getMedia(){
        return media;
    }
    public void setMedia(BigDecimal media){
        this.media=media;
    }
}
