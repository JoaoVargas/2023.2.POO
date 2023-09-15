package dados;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Email {
    private int idEmail;
    private String remetente;
    private String destinatario;
    private String assunto;
    private String mensagem;
    private LocalDateTime dataHora;
    private Email emailAnterior;

    public int getIdEmail() {
        return idEmail;
    }
    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
    }
    public String getRemetente() {
        return remetente;
    }
    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public String getAssunto() {
        return assunto;
    }
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora() {
        this.dataHora = LocalDateTime.now();
    }
    public Email getEmailAnterior() {
        return emailAnterior;
    }
    public void setEmailAnterior(Email emailAnterior) {
        this.emailAnterior = emailAnterior;
    }

    public Email() {
        this.emailAnterior = null;
    }

    @Override
    public String toString() {
        return """
                Assunto: %s
                De: %s
                Para: %s
                Data: %s
                
                %s
                ------------------------------------
                %s
                """.formatted(this.assunto,
                                this.destinatario,
                                this.remetente,
                                formatarDataTime(this.dataHora),
                                this.mensagem,
                                this.emailAnterior == null ? "" : this.emailAnterior.toString());
    }

    public String toStringResumido() {
        return """
                [%s] %s | %s""".formatted(this.idEmail, formatarDataTime(this.dataHora), this.assunto);
    }

    public String formatarDataTime(LocalDateTime d){
        return d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
