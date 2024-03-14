package eu.fr.mulesoft.gestion.service;

import java.util.List;
import eu.fr.mulesoft.gestion.entity.Utilisateur;

public interface IUtilisateurService {
	Utilisateur creerUtilisateur(Utilisateur user);
	Utilisateur modifierUtilisateur(Utilisateur user);
	void supprimerUtilisateur(Utilisateur user);
	Utilisateur rechercherUtilisateurParMatricule(String matricule);
	List<Utilisateur> listerUtilisateur();
	
}
