package tn.esprit.tpfoyer.service.chambre;

import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

public interface IChambreService {
    public List<Chambre> retrieveAllChambres();

    public Chambre retrieveChambre(Long chambreId);

    public Chambre addChambre(Chambre c);

    public void removeChambre(Long chambreId);

    public Chambre modifyChambre(Chambre chambre);

// Here we will add later methods calling keywords and methods calling JPQL
}