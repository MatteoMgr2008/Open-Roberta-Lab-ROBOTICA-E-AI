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

public class illabirintocontorto {
    private static Configuration brickConfiguration;

    private Set<UsedSensor> usedSensors = new LinkedHashSet<UsedSensor>(Arrays.asList(new UsedSensor(SensorPort.S3, SensorType.COLOR, ColorSensorMode.COLOUR)));
    private Hal hal = new Hal(brickConfiguration, usedSensors);

    public static void main(String[] args) {
        try {
             brickConfiguration = new EV3Configuration.Builder()
                .setWheelDiameter(5.6)
                .setTrackWidth(18.0)
                .addActor(ActorPort.B, new Actor(ActorType.LARGE, true, DriveDirection.FOREWARD, MotorSide.RIGHT))
                .addActor(ActorPort.C, new Actor(ActorType.LARGE, true, DriveDirection.FOREWARD, MotorSide.LEFT))
                .addSensor(SensorPort.S3, new Sensor(SensorType.COLOR))
                .build();

            new illabirintocontorto().run();
        } catch ( Exception e ) {
            Hal.displayExceptionWaitForKeyPress(e);
        }
    }


    public void run() throws Exception {
        hal.rotateDirectionAngle(TurnDirection.LEFT, 30, 90);
        hal.driveDistance(DriveDirection.FOREWARD, 50, 30);
        if ( true ) {
            while ( true ) {
                hal.regulatedDrive(DriveDirection.FOREWARD, 30);
                while ( true ) {
                    if ( hal.getColorSensorColour(SensorPort.S3) == PickColor.NONE ) {
                        hal.rotateDirectionRegulated(TurnDirection.RIGHT, 51);
                        break;
                    }
                    if ( hal.getColorSensorColour(SensorPort.S3) == PickColor.WHITE ) {
                        hal.rotateDirectionRegulated(TurnDirection.LEFT, 51);
                        break;
                    }
                    hal.waitFor(15);
                }
            }
        }
    }
}