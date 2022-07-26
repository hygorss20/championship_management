package com.championship.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Matches {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	private String local;

	@ManyToMany
	@JoinColumn(name="ID_TEAMS")
	private List<Teams> time;

	public List<Teams> getTime() {
		return time;
	}

	public void setTime(List<Teams> time) {
		this.time = time;
	}

	public Tournaments getTournaments() {
		return tournaments;
	}

	public void setTournaments(Tournaments tournaments) {
		this.tournaments = tournaments;
	}

	@ManyToOne
	@JoinColumn(name="ID_TOURNAMENTS")
	private Tournaments tournaments;
}
