package tn.ramzess.myapplication.business;


import com.github.mikephil.charting.data.Entry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Score {
    public static final boolean PERIODE_EN_COURS_OU_X_DERNIERS_SOUS_PERIODE = true;
    public static final int SCORE_ANNUEL = 1;
    public static final int SCORE_MENSUEL = 2;
    public static final int SCORE_HEBDOMADAIRE = 3;
    public static final int SCORE_JOURNALIER = 4;
    public static final int SCORE_ECO_CONDUIE = 5;
    public static final int SCORE_SECURITE = 5;


    private int typePeriodeScore;
    private int typeSecurite;
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
    ArrayList<Date> labels = new ArrayList<Date>();

    private Date dateDebut;
    private Date dateFin;

    public Score(int typePeriodeScore,int typeSecurite,Date dDebut,Date dFin) {
        this.typePeriodeScore = typePeriodeScore;
        this.typeSecurite = typeSecurite;
        dateDebut = dDebut;
        dateFin=dFin;
        this.periodeEnCoursOuXDernieresSousPeriode = PERIODE_EN_COURS_OU_X_DERNIERS_SOUS_PERIODE;
        estPeriodeEnCours=true;
        estScoreConduiteDemande=true;
        emissionTotalCO2 = 0;
        estTendanceHaussiere=true;
        consomationCible = 0;
        gainConsommation = 0;
        distanceParcourue = 0;
        dureeParcourue = 0;
        consommationTotale = 0;
        pourcentageMixeVille = 0;
        entries = new ArrayList<>();
        labels = new ArrayList<Date>();

        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");

        try {


            switch (typePeriodeScore) {
                case SCORE_ANNUEL:
                    labels.add(sdf.parse("01/01/2019"));
                    labels.add(sdf.parse("01/02/2019"));
                    labels.add(sdf.parse("01/03/2019"));
                    labels.add(sdf.parse("01/04/2019"));
                    labels.add(sdf.parse("01/05/2019"));
                    labels.add(sdf.parse("01/06/2019"));
                    labels.add(sdf.parse("01/07/2019"));
                    labels.add(sdf.parse("01/08/2019"));
                    labels.add(sdf.parse("01/09/2019"));
                    labels.add(sdf.parse("01/10/2019"));
                    labels.add(sdf.parse("01/11/2019"));
                    labels.add(sdf.parse("01/12/2019"));
                    for (int i = 0; i < labels.size(); i++) {
                        entries.add(new Entry(0, i));
                    }

                    break;
                case SCORE_MENSUEL:
                    labels.add(sdf.parse("01/01/2019"));
                    labels.add(sdf.parse("02/01/2019"));
                    labels.add(sdf.parse("03/01/2019"));
                    labels.add(sdf.parse("04/01/2019"));
                    labels.add(sdf.parse("05/01/2019"));
                    labels.add(sdf.parse("06/01/2019"));
                    labels.add(sdf.parse("07/01/2019"));
                    labels.add(sdf.parse("08/01/2019"));
                    labels.add(sdf.parse("09/01/2019"));
                    labels.add(sdf.parse("10/01/2019"));
                    labels.add(sdf.parse("11/01/2019"));
                    labels.add(sdf.parse("12/01/2019"));
                    labels.add(sdf.parse("13/01/2019"));
                    labels.add(sdf.parse("14/01/2019"));
                    labels.add(sdf.parse("15/01/2019"));
                    labels.add(sdf.parse("16/01/2019"));
                    labels.add(sdf.parse("17/01/2019"));
                    labels.add(sdf.parse("18/01/2019"));
                    labels.add(sdf.parse("19/01/2019"));
                    labels.add(sdf.parse("20/01/2019"));
                    labels.add(sdf.parse("21/01/2019"));
                    labels.add(sdf.parse("22/01/2019"));
                    labels.add(sdf.parse("23/01/2019"));
                    labels.add(sdf.parse("24/01/2019"));
                    labels.add(sdf.parse("25/01/2019"));
                    labels.add(sdf.parse("26/01/2019"));
                    labels.add(sdf.parse("27/01/2019"));
                    labels.add(sdf.parse("28/01/2019"));
                    labels.add(sdf.parse("29/01/2019"));
                    labels.add(sdf.parse("30/01/2019"));
                    labels.add(sdf.parse("31/01/2019"));
                    for (int i = 0; i < labels.size(); i++) {
                        entries.add(new Entry((float)Math.random(), i));
                    }
                    break;
                case SCORE_HEBDOMADAIRE:
                    labels.add(sdf.parse("01/01/2019"));
                    labels.add(sdf.parse("02/01/2019"));
                    labels.add(sdf.parse("03/01/2019"));
                    labels.add(sdf.parse("04/01/2019"));
                    labels.add(sdf.parse("05/01/2019"));
                    labels.add(sdf.parse("06/01/2019"));
                    labels.add(sdf.parse("07/01/2019"));
                    for (int i = 0; i < labels.size(); i++) {
                        entries.add(new Entry((float)Math.random(), i));
                    }
                    break;
                default:
                    break;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public double getDistanceParcourue() {
        return distanceParcourue;
    }

    public void setDistanceParcourue(double distanceParcourue) {
        this.distanceParcourue = distanceParcourue;
    }

    public double getDureeParcourue() {
        return dureeParcourue;
    }

    public void setDureeParcourue(double dureeParcourue) {
        this.dureeParcourue = dureeParcourue;
    }

    public double getConsommationTotale() {
        return consommationTotale;
    }

    public void setConsommationTotale(double consommationTotale) {
        this.consommationTotale = consommationTotale;
    }
/*
    public Score(int typePeriodeScore, boolean periodeEnCoursOuXDernieresSousPeriode) {
        this.typePeriodeScore = typePeriodeScore;
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
        labels = new ArrayList<Date>();

        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");

        try {


            switch (typePeriodeScore) {
                case EST_SCORE_ANNUEL:
                    labels.add(sdf.parse("01/01/2019"));
                    labels.add(sdf.parse("01/02/2019"));
                    labels.add(sdf.parse("01/03/2019"));
                    labels.add(sdf.parse("01/04/2019"));
                    labels.add(sdf.parse("01/05/2019"));
                    labels.add(sdf.parse("01/06/2019"));
                    labels.add(sdf.parse("01/07/2019"));
                    labels.add(sdf.parse("01/08/2019"));
                    labels.add(sdf.parse("01/09/2019"));
                    labels.add(sdf.parse("01/10/2019"));
                    labels.add(sdf.parse("01/11/2019"));
                    labels.add(sdf.parse("01/12/2019"));
                    for (int i = 0; i < labels.size(); i++) {
                        entries.add(new Entry(0, i));
                    }
                    break;
                case EST_SCORE_MENSUEL:
                    labels.add(sdf.parse("01/01/2019"));
                    labels.add(sdf.parse("02/01/2019"));
                    labels.add(sdf.parse("03/01/2019"));
                    labels.add(sdf.parse("04/01/2019"));
                    labels.add(sdf.parse("05/01/2019"));
                    labels.add(sdf.parse("06/01/2019"));
                    labels.add(sdf.parse("07/01/2019"));
                    labels.add(sdf.parse("08/01/2019"));
                    labels.add(sdf.parse("09/01/2019"));
                    labels.add(sdf.parse("10/01/2019"));
                    labels.add(sdf.parse("11/01/2019"));
                    labels.add(sdf.parse("12/01/2019"));
                    labels.add(sdf.parse("13/01/2019"));
                    labels.add(sdf.parse("14/01/2019"));
                    labels.add(sdf.parse("15/01/2019"));
                    labels.add(sdf.parse("16/01/2019"));
                    labels.add(sdf.parse("17/01/2019"));
                    labels.add(sdf.parse("18/01/2019"));
                    labels.add(sdf.parse("19/01/2019"));
                    labels.add(sdf.parse("20/01/2019"));
                    labels.add(sdf.parse("21/01/2019"));
                    labels.add(sdf.parse("22/01/2019"));
                    labels.add(sdf.parse("23/01/2019"));
                    labels.add(sdf.parse("24/01/2019"));
                    labels.add(sdf.parse("25/01/2019"));
                    labels.add(sdf.parse("26/01/2019"));
                    labels.add(sdf.parse("27/01/2019"));
                    labels.add(sdf.parse("28/01/2019"));
                    labels.add(sdf.parse("29/01/2019"));
                    labels.add(sdf.parse("30/01/2019"));
                    labels.add(sdf.parse("31/01/2019"));
                    for (int i = 0; i < labels.size(); i++) {
                        entries.add(new Entry(0, i));
                    }
                    break;
                case EST_SCORE_HEBDOMADAIRE:
                    labels.add(sdf.parse("01/01/2019"));
                    labels.add(sdf.parse("02/01/2019"));
                    labels.add(sdf.parse("03/01/2019"));
                    labels.add(sdf.parse("04/01/2019"));
                    labels.add(sdf.parse("05/01/2019"));
                    labels.add(sdf.parse("06/01/2019"));
                    labels.add(sdf.parse("07/01/2019"));
                    for (int i = 0; i < labels.size(); i++) {
                        entries.add(new Entry(0, i));
                    }
                    break;
                default:
                    break;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }*/


    public ArrayList<String> getLabels() {
        ArrayList<String> strlabels = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d;
        String s;
        for(int i =0;i<labels.size();i++)
        {
            d = labels.get(i);
            s = sdf.format(d);
            strlabels.add(s);
        }
        return strlabels;
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    public void setValueOf(Date date, float value )
    {
        for(int i=0;i<labels.size()-1;i++)
        {
            if(date.after(labels.get(i)) && date.before(labels.get(i+1)))
            {
                entries.get(i).setVal(value);
                return;
            }
        }
        long intervalle = labels.get(1).getTime()-labels.get(0).getTime();
        long dateprochaine = labels.get(labels.size()-1).getTime()+intervalle;
        Date d = new Date(dateprochaine);

        if(date.after(labels.get(labels.size()-1))&&date.before(d))
        {
            entries.get(labels.size()-1).setVal(value);
        }
    }

    public int getTypeScore() {
        return typePeriodeScore;
    }

    public boolean isPeriodeEnCoursOuXDernieresSousPeriode() {
        return periodeEnCoursOuXDernieresSousPeriode;
    }

    public boolean isEstPeriodeEnCours() {
        return estPeriodeEnCours;
    }

    public boolean isEstScoreConduiteDemande() {
        return estScoreConduiteDemande;
    }

    public double getEmissionTotalCO2() {
        return emissionTotalCO2;
    }

    public boolean isEstTendanceHaussiere() {
        return estTendanceHaussiere;
    }

    public double getConsomationCible() {
        return consomationCible;
    }

    public double getGainConsommation() {
        return gainConsommation;
    }

    public double getPourcentageMixeVille() {
        return pourcentageMixeVille;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setTypeScore(int typePeriodeScore) {
        this.typePeriodeScore = typePeriodeScore;
    }

    public void setPeriodeEnCoursOuXDernieresSousPeriode(boolean periodeEnCoursOuXDernieresSousPeriode) {
        this.periodeEnCoursOuXDernieresSousPeriode = periodeEnCoursOuXDernieresSousPeriode;
    }

    public void setEstPeriodeEnCours(boolean estPeriodeEnCours) {
        this.estPeriodeEnCours = estPeriodeEnCours;
    }

    public void setEstScoreConduiteDemande(boolean estScoreConduiteDemande) {
        this.estScoreConduiteDemande = estScoreConduiteDemande;
    }

    public void setEmissionTotalCO2(double emissionTotalCO2) {
        this.emissionTotalCO2 = emissionTotalCO2;
    }

    public void setEstTendanceHaussiere(boolean estTendanceHaussiere) {
        this.estTendanceHaussiere = estTendanceHaussiere;
    }

    public void setConsomationCible(double consomationCible) {
        this.consomationCible = consomationCible;
    }

    public void setGainConsommation(double gainConsommation) {
        this.gainConsommation = gainConsommation;
    }

    public void setPourcentageMixeVille(double pourcentageMixeVille) {
        this.pourcentageMixeVille = pourcentageMixeVille;
    }

    public void setEntries(ArrayList<Entry> entries) {
        this.entries = entries;
    }

    public void setLabels(ArrayList<Date> labels) {
        this.labels = labels;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}


