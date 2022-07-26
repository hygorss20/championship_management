package com.championship.domain.dto;

import com.championship.domain.model.Teams;
import com.championship.domain.model.Tournaments;

import java.util.List;

public class MatchesDTO
{
	private Long id;

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	private String local;

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

	private Tournaments tournaments;
}
