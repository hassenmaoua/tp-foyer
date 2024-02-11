package tn.esprit.tpfoyer.service.universite;

import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService{
    public List<Universite> retrieveAllUniversites();

    public Universite retrieveUniversite(Long universiteId);

    public Universite addUniversite(Universite c);

    public void removeUniversite(Long universiteId);

    public Universite modifyUniversite(Universite universite);
}
