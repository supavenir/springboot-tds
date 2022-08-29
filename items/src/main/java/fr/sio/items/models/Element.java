package fr.sio.items.models;

public class Element {
	private String nom;
	private int evaluation = 5;

	public Element(String name) {
		this.nom = name;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Element)) {
			return false;
		}
		return ((Element) obj).getEvaluation() == evaluation;
	}

}
