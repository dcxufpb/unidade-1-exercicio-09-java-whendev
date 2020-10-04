package com.example.project;

public class Loja {

    private String nomeLoja;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String estado;
    private String cep;
    private String telefone;
    private String observacao;
    private String cnpj;
    private String inscricaoEstadual;

    public Loja(String nomeLoja, String logradouro, int numero, String complemento, String bairro, String municipio,
            String estado, String cep, String telefone, String observacao, String cnpj, String inscricaoEstadual) {
        this.nomeLoja = nomeLoja;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
        this.observacao = observacao;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getCep() {
        return this.cep;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public static Boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public String dadosLoja(Loja loja) {
		// Implemente aqui
        if (isNullOrEmpty(loja.getNomeLoja())){
            throw new RuntimeException("O campo nome da loja é obrigatório");
        }

        if (isNullOrEmpty(loja.getLogradouro())){
            throw new RuntimeException("O campo logradouro do endereço é obrigatório");
        }

        if (isNullOrEmpty(loja.getMunicipio())){
            throw new RuntimeException("O campo município do endereço é obrigatório");
        }

        if (isNullOrEmpty(loja.getEstado())){
            throw new RuntimeException("O campo estado do endereço é obrigatório");
        }

        if (isNullOrEmpty(loja.getCnpj())){
            throw new RuntimeException("O campo cnpj da loja é obrigatório");
        }

        if (isNullOrEmpty(loja.getInscricaoEstadual())) {
            throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
        }

        String _COMPLEMENTO = "";
        if (!isNullOrEmpty(loja.getComplemento())){
            _COMPLEMENTO = " " + loja.getComplemento();
        }

        String _BAIRRO = "";
        if (!isNullOrEmpty(loja.getBairro())) {
            _BAIRRO = loja.getBairro() + " - ";
        }

        String _CEP = "";
        String _TELEFONE = "";

        if (!isNullOrEmpty(loja.getCep())) {
            _CEP = "CEP:" + loja.getCep();
            if (!isNullOrEmpty(loja.getTelefone())){
                _TELEFONE = " Tel " + loja.getTelefone();
            }
        } else {
            _CEP = "";
            if (!isNullOrEmpty(loja.getTelefone())){
                _TELEFONE = "Tel " + loja.getTelefone();
            }
        }

        String _OBSERVACAO = "";
        if (!isNullOrEmpty(loja.getObservacao())){
            _OBSERVACAO = loja.getObservacao();
        }

        String _texto = "";
        _texto = String.format("%s\r\n",loja.getNomeLoja());
        if (loja.getNumero() == 0){
            _texto += String.format("%s, %s%s\r\n",loja.getLogradouro(),"s/n",_COMPLEMENTO);
        } else {
            _texto += String.format("%s, %d%s\r\n",loja.getLogradouro(),loja.getNumero(),_COMPLEMENTO);
        }
        _texto += String.format("%s%s - %s\r\n",_BAIRRO,loja.getMunicipio(),loja.getEstado());
        _texto += String.format("%s%s\r\n",_CEP,_TELEFONE);
        _texto += String.format("%s\r\n",_OBSERVACAO);
        _texto += String.format("CNPJ: %s\r\n",loja.getCnpj());
        _texto += String.format("IE: %s\r\n",loja.getInscricaoEstadual());
        return _texto;
	}

}