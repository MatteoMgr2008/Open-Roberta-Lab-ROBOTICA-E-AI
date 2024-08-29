package generated.main;

import de.fhg.iais.roberta.runtime.*;
import de.fhg.iais.roberta.runtime.ev3.*;

import de.fhg.iais.roberta.mode.general.*;
import de.fhg.iais.roberta.mode.action.*;
import de.fhg.iais.roberta.mode.sensor.*;
import de.fhg.iais.roberta.mode.action.ev3.*;
import de.fhg.iais.roberta.mode.sensor.ev3.*;

import de.fhg.iais.roberta.components.*;

import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import lejos.remote.nxt.NXTConnection;

public class Ilrobotincitta {
    private static Configuration brickConfiguration;

    private Set<UsedSensor> usedSensors = new LinkedHashSet<UsedSensor>();
    private Hal hal = new Hal(brickConfiguration, usedSensors);

    public static void main(String[] args) {
        try {
             brickConfiguration = new EV3Configuration.Builder()
                .setWheelDiameter(5.6)
                .setTrackWidth(18.0)
                .addActor(ActorPort.B, new Actor(ActorType.LARGE, true, DriveDirection.FOREWARD, MotorSide.RIGHT))
                .addActor(ActorPort.C, new Actor(ActorType.LARGE, true, DriveDirection.FOREWARD, MotorSide.LEFT))
                .build();

            new Ilrobotincitta().run();
        } catch ( Exception e ) {
            Hal.displayExceptionWaitForKeyPress(e);
        }
    }


    public void run() throws Exception {
        hal.startLogging();
        hal.ledOn(BrickLedColor.RED, BlinkMode.FLASH);
        hal.driveDistance(DriveDirection.BACKWARD, 10, 29);
        hal.rotateDirectionAngle(TurnDirection.RIGHT, 30, 90);
        hal.waitFor(1000);
        hal.driveDistance(DriveDirection.FOREWARD, 30, 28);
        hal.rotateDirectionAngle(TurnDirection.LEFT, 30, 90);
        hal.driveDistance(DriveDirection.FOREWARD, 50, 36);
        hal.waitFor(1000);
        hal.regulatedDrive(DriveDirection.FOREWARD, 30);
        hal.driveDistance(DriveDirection.FOREWARD, 30, 30);
        hal.rotateDirectionAngle(TurnDirection.RIGHT, 30, 90);
        hal.driveDistance(DriveDirection.FOREWARD, 70, 110);
        hal.waitFor(1000);
        hal.driveDistance(DriveDirection.FOREWARD, 20, 30);
        hal.rotateDirectionAngle(TurnDirection.LEFT, 30, 115);
        hal.driveInCurve(DriveDirection.FOREWARD, 2, 0, 2);
        hal.driveDistance(DriveDirection.FOREWARD, 30, 75);
        hal.rotateDirectionAngle(TurnDirection.LEFT, 30, 80);
        hal.driveDistance(DriveDirection.FOREWARD, 20, 15);
        hal.driveInCurve(DriveDirection.FOREWARD, 0, 1, 1);
        hal.driveDistance(DriveDirection.FOREWARD, 20, 13);
        hal.closeResources();

    }
}