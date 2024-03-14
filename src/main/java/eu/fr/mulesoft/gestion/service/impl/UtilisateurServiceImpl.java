package eu.fr.mulesoft.gestion.service.impl;

import java.util.ArrayList;
import java.util.List;


import eu.fr.mulesoft.gestion.entity.Utilisateur;
import eu.fr.mulesoft.gestion.service.IUtilisateurService;

public class UtilisateurServiceImpl implements IUtilisateurService {
	
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	public UtilisateurServiceImpl() {
		Utilisateur user1 = new Utilisateur("0001","Zappa","Frank");
		Utilisateur user2 = new Utilisateur("0002","Clapton","Eric");
		Utilisateur user3 = new Utilisateur("0003","Pop","Iggy");
		
		this.utilisateurs.add(user1);
		this.utilisateurs.add(user2);
		this.utilisateurs.add(user3);
	}
	
	public Utilisateur creerUtilisateur(Utilisateur user) {
		this.utilisateurs.add(user);
		System.out.println(utilisateurs);
		return user;
	}

	@Override
	public Utilisateur modifierUtilisateur(Utilisateur user) {
		Utilisateur utilisateur = this.rechercherUtilisateurParMatricule(user.getMatricule());
		if (utilisateur !=null) {
			utilisateur.setNom(user.getNom());
			utilisateur.setPrenom(user.getPrenom());
		}
		return utilisateur;
	}

	@Override
	public void supprimerUtilisateur(Utilisateur user) {
		Utilisateur utilisateur = this.rechercherUtilisateurParMatricule(user.getMatricule());
		if (utilisateur !=null) {
			this.utilisateurs.remove(utilisateur);
		} else { 
		throw new IllegalStateException("Aucun utilsateur à supprimer");
		}
	}

	@Override
	public Utilisateur rechercherUtilisateurParMatricule(String matricule) {
		for (Utilisateur utilisateur:utilisateurs) {
			if (utilisateur.getMatricule().equals(matricule)){
				return utilisateur;
			}
		}
		return null;
	}

	@Override
	public List<Utilisateur> listerUtilisateur() {
		if (utilisateurs.isEmpty()) {
			throw new IllegalStateException("Votre base est vide");
		}
		return utilisateurs;
	}

}
