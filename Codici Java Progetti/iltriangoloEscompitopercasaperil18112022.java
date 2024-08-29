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

public class iltriangoloEscompitopercasaperil18112022 {
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

            new iltriangoloEscompitopercasaperil18112022().run();
        } catch ( Exception e ) {
            Hal.displayExceptionWaitForKeyPress(e);
        }
    }


    public void run() throws Exception {
        hal.ledOn(BrickLedColor.RED, BlinkMode.FLASH);
        hal.driveDistance(DriveDirection.FOREWARD, 50, 90);
        hal.rotateDirectionAngle(TurnDirection.LEFT, 50, 125);
        hal.driveDistance(DriveDirection.FOREWARD, 30, 80);
        hal.rotateDirectionAngle(TurnDirection.LEFT, 30, 110);
        hal.driveDistance(DriveDirection.FOREWARD, 30, 77);
        hal.rotateDirectionAngle(TurnDirection.LEFT, 30, 125);
    }
}