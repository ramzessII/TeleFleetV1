package tn.ramzess.myapplication.business;

import java.util.Date;
import java.util.Objects;

public class Activity {
    private Date date;
    private Float distance;
    private String averageSpeed;
    private String maxSpeed;
    private String drivingTime;
    private String standbyTime;
    private String stopTime;
    private String workingTime;
    private String privateTime;
    private String notAssociatedTime;
    private String input1Time;
    private Float drivingTheoreticalConsumption;
    private Float drivingCO2;
    private Float standByTheoreticalConsumption;
    private Float standByCO2;
    private Float drivingConsumption;
    private Float standByConsumption;
    private Integer harshAccelerations;
    private Integer harshBrakings;
    private Integer harshTurns;
    private Integer tripCount;
    private String speed0Time;
    private Date speed1Time;
    private Float speed2Time;
    private String speed3Time;
    private String rpm0Time;
    private String rpm1Time;
    private String rpm2Tim;

    public Activity() {
        date = new Date();
        distance = 0.0f;
        averageSpeed = "";
        maxSpeed = "";
        drivingTime = "";
        standbyTime = "";
        stopTime = "";
        workingTime = "";
        privateTime = "";
        notAssociatedTime = "";
        input1Time = "";
        drivingTheoreticalConsumption = 0.0f;
        drivingCO2 = 0.0f;
        standByTheoreticalConsumption = 0.0f;
        standByCO2 = 0.0f;
        drivingConsumption = 0.0f;
        standByConsumption = 0.0f;
        harshAccelerations = 0;
        harshBrakings = 0;
        harshTurns = 0;
        tripCount = 0;
        speed0Time = "";
        speed1Time = new Date();
        speed2Time = 0.0f;
        speed3Time = "";
        rpm0Time = "";
        rpm1Time = "";
        rpm2Tim = "";
    }

    public boolean equals(Activity o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        if (	this.getDate() == o.getDate() &&
                this.getDistance() == o.getDistance() &&
                this.getAverageSpeed() == o.getAverageSpeed() &&
                this.getMaxSpeed() == o.getMaxSpeed() &&
                this.getDrivingTime() == o.getDrivingTime() &&
                this.getStandbyTime() == o.getStandbyTime() &&
                this.getStopTime() == o.getStopTime() &&
                this.getWorkingTime() == o.getWorkingTime() &&
                this.getPrivateTime() == o.getPrivateTime() &&
                this.getNotAssociatedTime() == o.getNotAssociatedTime() &&
                this.getInput1Time() == o.getInput1Time() &&
                this.getDrivingTheoreticalConsumption() == o.getDrivingTheoreticalConsumption() &&
                this.getDrivingCO2() == o.getDrivingCO2() &&
                this.getStandByTheoreticalConsumption() == o.getStandByTheoreticalConsumption() &&
                this.getStandByCO2() == o.getStandByCO2() &&
                this.getDrivingConsumption() == o.getDrivingConsumption() &&
                this.getStandByConsumption() == o.getStandByConsumption() &&
                this.getHarshAccelerations() == o.getHarshAccelerations() &&
                this.getHarshBrakings() == o.getHarshBrakings() &&
                this.getHarshTurns() == o.getHarshTurns() &&
                this.getTripCount() == o.getTripCount() &&
                this.getSpeed0Time() == o.getSpeed0Time() &&
                this.getSpeed1Time() == o.getSpeed1Time() &&
                this.getSpeed2Time() == o.getSpeed2Time() &&
                this.getSpeed3Time() == o.getSpeed3Time() &&
                this.getRpm0Time() == o.getRpm0Time() &&
                this.getRpm1Time() == o.getRpm1Time() &&
                this.getRpm2Tim() == o.getRpm2Tim())
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "date=" + date +
                ", distance=" + distance +
                ", averageSpeed='" + averageSpeed + '\'' +
                ", maxSpeed='" + maxSpeed + '\'' +
                ", drivingTime='" + drivingTime + '\'' +
                ", standbyTime='" + standbyTime + '\'' +
                ", stopTime='" + stopTime + '\'' +
                ", workingTime='" + workingTime + '\'' +
                ", privateTime='" + privateTime + '\'' +
                ", notAssociatedTime='" + notAssociatedTime + '\'' +
                ", input1Time='" + input1Time + '\'' +
                ", drivingTheoreticalConsumption=" + drivingTheoreticalConsumption +
                ", drivingCO2=" + drivingCO2 +
                ", standByTheoreticalConsumption=" + standByTheoreticalConsumption +
                ", standByCO2=" + standByCO2 +
                ", drivingConsumption=" + drivingConsumption +
                ", standByConsumption=" + standByConsumption +
                ", harshAccelerations=" + harshAccelerations +
                ", harshBrakings=" + harshBrakings +
                ", harshTurns=" + harshTurns +
                ", tripCount=" + tripCount +
                ", speed0Time='" + speed0Time + '\'' +
                ", speed1Time=" + speed1Time +
                ", speed2Time=" + speed2Time +
                ", speed3Time='" + speed3Time + '\'' +
                ", rpm0Time='" + rpm0Time + '\'' +
                ", rpm1Time='" + rpm1Time + '\'' +
                ", rpm2Tim='" + rpm2Tim + '\'' +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(String averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getDrivingTime() {
        return drivingTime;
    }

    public void setDrivingTime(String drivingTime) {
        this.drivingTime = drivingTime;
    }

    public String getStandbyTime() {
        return standbyTime;
    }

    public void setStandbyTime(String standbyTime) {
        this.standbyTime = standbyTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public String getPrivateTime() {
        return privateTime;
    }

    public void setPrivateTime(String privateTime) {
        this.privateTime = privateTime;
    }

    public String getNotAssociatedTime() {
        return notAssociatedTime;
    }

    public void setNotAssociatedTime(String notAssociatedTime) {
        this.notAssociatedTime = notAssociatedTime;
    }

    public String getInput1Time() {
        return input1Time;
    }

    public void setInput1Time(String input1Time) {
        this.input1Time = input1Time;
    }

    public Float getDrivingTheoreticalConsumption() {
        return drivingTheoreticalConsumption;
    }

    public void setDrivingTheoreticalConsumption(Float drivingTheoreticalConsumption) {
        this.drivingTheoreticalConsumption = drivingTheoreticalConsumption;
    }

    public Float getDrivingCO2() {
        return drivingCO2;
    }

    public void setDrivingCO2(Float drivingCO2) {
        this.drivingCO2 = drivingCO2;
    }

    public Float getStandByTheoreticalConsumption() {
        return standByTheoreticalConsumption;
    }

    public void setStandByTheoreticalConsumption(Float standByTheoreticalConsumption) {
        this.standByTheoreticalConsumption = standByTheoreticalConsumption;
    }

    public Float getStandByCO2() {
        return standByCO2;
    }

    public void setStandByCO2(Float standByCO2) {
        this.standByCO2 = standByCO2;
    }

    public Float getDrivingConsumption() {
        return drivingConsumption;
    }

    public void setDrivingConsumption(Float drivingConsumption) {
        this.drivingConsumption = drivingConsumption;
    }

    public Float getStandByConsumption() {
        return standByConsumption;
    }

    public void setStandByConsumption(Float standByConsumption) {
        this.standByConsumption = standByConsumption;
    }

    public Integer getHarshAccelerations() {
        return harshAccelerations;
    }

    public void setHarshAccelerations(Integer harshAccelerations) {
        this.harshAccelerations = harshAccelerations;
    }

    public Integer getHarshBrakings() {
        return harshBrakings;
    }

    public void setHarshBrakings(Integer harshBrakings) {
        this.harshBrakings = harshBrakings;
    }

    public Integer getHarshTurns() {
        return harshTurns;
    }

    public void setHarshTurns(Integer harshTurns) {
        this.harshTurns = harshTurns;
    }

    public Integer getTripCount() {
        return tripCount;
    }

    public void setTripCount(Integer tripCount) {
        this.tripCount = tripCount;
    }

    public String getSpeed0Time() {
        return speed0Time;
    }

    public void setSpeed0Time(String speed0Time) {
        this.speed0Time = speed0Time;
    }

    public Date getSpeed1Time() {
        return speed1Time;
    }

    public void setSpeed1Time(Date speed1Time) {
        this.speed1Time = speed1Time;
    }

    public Float getSpeed2Time() {
        return speed2Time;
    }

    public void setSpeed2Time(Float speed2Time) {
        this.speed2Time = speed2Time;
    }

    public String getSpeed3Time() {
        return speed3Time;
    }

    public void setSpeed3Time(String speed3Time) {
        this.speed3Time = speed3Time;
    }

    public String getRpm0Time() {
        return rpm0Time;
    }

    public void setRpm0Time(String rpm0Time) {
        this.rpm0Time = rpm0Time;
    }

    public String getRpm1Time() {
        return rpm1Time;
    }

    public void setRpm1Time(String rpm1Time) {
        this.rpm1Time = rpm1Time;
    }

    public String getRpm2Tim() {
        return rpm2Tim;
    }

    public void setRpm2Tim(String rpm2Tim) {
        this.rpm2Tim = rpm2Tim;
    }
}
