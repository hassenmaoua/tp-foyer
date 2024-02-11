package tn.esprit.tpfoyer.service.bloc;

import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface IBlocService{
    public List<Bloc> retrieveAllBlocs();

    public Bloc retrieveBloc(Long blocId);

    public Bloc addBloc(Bloc c);

    public void removeBloc(Long blocId);

    public Bloc modifyBloc(Bloc bloc);
}
