package tn.ramzess.myapplication.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tn.ramzess.myapplication.business.Activity;
import tn.ramzess.myapplication.business.Chauffeur;
import tn.ramzess.myapplication.business.Score;
import tn.ramzess.myapplication.business.Trajet;


public final class Database {
    private static List<Activity> activitiesdao = new ArrayList<>();
    private static List<Trajet> trajetsDao = new ArrayList<>();

    public Database() {
        Chauffeur chauffeur = new Chauffeur(1,"Bond","James");
        double distance = Math.random()*150;
        for(int i=0;i<100;i++)
        {
            trajetsDao.add(new Trajet(chauffeur,distance));
        }




    }

    public Score getScore(Chauffeur chauffeur, Date dateDebut, Date dateFin, int typeScore)
    {
        Score score = new Score(typeScore);
        double distanceParourue = 0;
        long duree = 0;
        double consommation = 0;
        for(int i=0;i<trajetsDao.size();i++)
        {
            Trajet trajet = trajetsDao.get(i);
            if(trajet.getChauffeur().equals(chauffeur))
            {
                Date ddep = trajet.getDeplacementDepart().getDate();

                if(dateDebut.compareTo(ddep) * ddep.compareTo(dateFin) >= 0)
                {
                    distanceParourue += trajet.getDistance();
                    duree += trajet.getDuree().getTime();
                    consommation += trajet.getConsommation();
                }
            }
        }
        score.setDistanceParcourue(distanceParourue);
        score.setDureeParcourue(duree);
        score.setConsommationTotale(consommation);

        return score;
    }



    public Activity getActivity(int index)
    {
        if (index > activitiesdao.size())
        {
            return null;
        }
        return activitiesdao.get(index);
    }


}
