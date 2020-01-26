package tn.ramzess.myapplication.business;


import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Date;

public class Score {
    public static final boolean PERIODE_EN_COURS_OU_X_DERNIERS_SOUS_PERIODE = true;
    public static final int EST_SCORE_ANNUEL = 1;
    public static final int EST_SCORE_MENSUEL = 2;
    public static final int EST_SCORE_HEBDOMADAIRE = 3;
    public static final int EST_SCORE_JOURNALIER = 4;


    private int typeScore;
    private boolean periodeEnCoursOuXDernieresSousPeriode;
    private boolean estPeriodeEnCours;

    private boolean estScoreConduiteDemande;
    private double emissionTotalCO2 = 0;
    private boolean estTendanceHaussiere;
    private double consomationCible;
    private double gainConsommation;
    private double distanceParcourue;
    private double dureeParcourue;
    private double consommationTotale;
    private double pourcentageMixeVille;
    ArrayList<Entry> entries = new ArrayList<>();
    LineDataSet dataset = new LineDataSet(entries, "# de Scores");
    ArrayList<String> labels = new ArrayList<String>();

    private Date dateDebut;
    private Date dateFin;

    public Score(int typeScore,boolean periodeEnCoursOuXDernieresSousPeriode) {
        this.typeScore = typeScore;
        this.periodeEnCoursOuXDernieresSousPeriode = periodeEnCoursOuXDernieresSousPeriode;
        if(Math.random()>0.5)estPeriodeEnCours=true;else estPeriodeEnCours=false;
        if(Math.random()>0.5)estScoreConduiteDemande=true;else estScoreConduiteDemande=false;
        emissionTotalCO2 = Math.random()*1200;
        if(Math.random()>0.5)estTendanceHaussiere=true;else estTendanceHaussiere=false;
        consomationCible = Math.random()*1522;
        gainConsommation = Math.random()*1522;
        distanceParcourue = Math.random()*20142;
        dureeParcourue = Math.random()*11458;
        consommationTotale = Math.random()*70000;
        pourcentageMixeVille = Math.random();
        entries = new ArrayList<>();
        dataset = new LineDataSet(entries, "# de Scores");
        labels = new ArrayList<String>();
        if (typeScore==this.EST_SCORE_ANNUEL) {
            labels.add("Janvier");
            labels.add("Février");
            labels.add("Mars");
            labels.add("Avril");
            labels.add("Mai");
            labels.add("Juin");
            labels.add("Juillet");
            labels.add("Août");
            labels.add("Septembre");
            labels.add("Octobre");
            labels.add("Novobre");
            labels.add("Decembre");
            for(int i=0;i<labels.size();i++) {
                entries.add(new Entry((float)Math.random()*20, i));
            }
        } else if(typeScore==this.EST_SCORE_MENSUEL)
        {
            for(int i=0;i<31;i++) {
                labels.add(Integer.toString(i));
                entries.add(new Entry((float)Math.random()*20, i));
            }
        }
        else if (typeScore==this.EST_SCORE_HEBDOMADAIRE)
        {
            labels.add("Lundi");
            labels.add("Mardi");
            labels.add("Mercredi");
            labels.add("Jeudi");
            labels.add("Vendredi");
            labels.add("Samedi");
            labels.add("Dimanche");
            for(int i=0;i<labels.size();i++) {
                entries.add(new Entry((float)Math.random()*20, i));
            }
        }
    }

    public LineDataSet getDataset() {
        return dataset;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }
}


