package silveira.caio.estudantes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matri;
	private String nome;
	private String email;
	private String fone;
	private String ende;
	
	public Estudante() {
		// TODO Auto-generated constructor stub
	}

	public Estudante(String nome, String email, String fone, String ende) {
		super();
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		this.ende = ende;
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

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEnde() {
		return ende;
	}

	public void setEnde(String ende) {
		this.ende = ende;
	}

	public Long getMatri() {
		return matri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matri == null) ? 0 : matri.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		if (matri == null) {
			if (other.matri != null)
				return false;
		} else if (!matri.equals(other.matri))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
