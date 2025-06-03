package fiap.global_solution_java.models;

import java.util.Objects;

public class User {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private boolean autenticacaoDoisFatores;

    public User() {
    }

    public User(Long id, String nome, String email, String senha, boolean autenticacaoDoisFatores) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.autenticacaoDoisFatores = autenticacaoDoisFatores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAutenticacaoDoisFatores() {
        return autenticacaoDoisFatores;
    }

    public void setAutenticacaoDoisFatores(boolean autenticacaoDoisFatores) {
        this.autenticacaoDoisFatores = autenticacaoDoisFatores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
