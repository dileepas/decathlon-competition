package com.decathlon_competition.enums;

public enum PointsSystemEnum {
    HM("HUNDRED_METER", 25.4347, 18,1.81, TypeOfMeasureEnum.TIME),
    LJ("LONG_JUMP", 0.14354, 220,1.4, TypeOfMeasureEnum.DISTANCE),
    SP("SHOT_PUT", 51.39, 1.5,1.05, TypeOfMeasureEnum.DISTANCE),
    HJ("HIGH_JUMP", 0.8465, 75,1.42, TypeOfMeasureEnum.DISTANCE),
    FM("FOUR_HUNDRED_METER", 1.53775, 82,1.81, TypeOfMeasureEnum.TIME),
    HMH("HUNDRED_METER_HURDLE", 5.74352, 28.5,1.92, TypeOfMeasureEnum.TIME),
    DT("DISCUS_THROW", 12.91, 4,1.1, TypeOfMeasureEnum.DISTANCE),
    PV("POLE_VAULT", 0.2797, 100,1.35, TypeOfMeasureEnum.DISTANCE),
    JT("JAVELIN_THROW", 10.14, 7,1.08, TypeOfMeasureEnum.DISTANCE),
    TFM("THOUSAND_FIVE_METER", 0.03768, 480,1.85, TypeOfMeasureEnum.TIME);

    private final String EventCode;
    private final double a;
    private final double b;
    private final double c;
    private final TypeOfMeasureEnum unitOfMeasure;

    PointsSystemEnum(String eventCode, double a, double b, double c, TypeOfMeasureEnum unitOfMeasure) {
        EventCode = eventCode;
        this.a = a;
        this.b = b;
        this.c = c;
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getEventCode() {
        return EventCode;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public TypeOfMeasureEnum getUnitOfMeasure() {
        return unitOfMeasure;
    }
}
