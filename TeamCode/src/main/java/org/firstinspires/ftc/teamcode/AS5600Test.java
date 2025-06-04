package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivers.AS5600;

/*
 * Created by Dryw Wade
 *
 * OpMode for testing Adafruit's MCP9808 temperature sensor driver
 */
@TeleOp(name = "AS5600", group = "Tests")
public class AS5600Test extends LinearOpMode
{
    private AS5600 magneticEncoder;

    public void runOpMode() throws InterruptedException
    {
        magneticEncoder = hardwareMap.get(AS5600.class, "magneticEncoder01");

        // Uncomment to use parameter version of driver class. This will require you to respecify
        // the sensor type from MCP9808 to MCP9808Params
//        MCP9808Params.Parameters parameters = new MCP9808Params.Parameters();
//        parameters.hysteresis = MCP9808Params.Hysteresis.HYST_1_5;
//        parameters.alertControl = MCP9808Params.AlertControl.ALERT_ENABLE;
//        tempSensor.initialize(parameters);

//        magneticEncoder.setTemperatureLimit(24, MCP9808.Register.T_LIMIT_LOWER);
//        magneticEncoder.setTemperatureLimit(26, MCP9808.Register.T_LIMIT_UPPER);
//        magneticEncoder.setTemperatureLimit(25, MCP9808.Register.T_LIMIT_CRITICAL);

        waitForStart();

        while(opModeIsActive()) {
            if (gamepad1.a) {
                magneticEncoder.setStartPositionToZero();
            }
            else {
                telemetry.addData("Zero Position Set", "not set");
            }

            telemetry.addData("Manufacturer", magneticEncoder.getManufacturer());
            telemetry.addData("Device Name", magneticEncoder.getDeviceName());
            telemetry.addData("Status Raw", magneticEncoder.getStatusRaw());
            telemetry.addData("Is Magnet Detected?", magneticEncoder.isMagnetDetected());
            telemetry.addData("Is Magnet Too Weak?", magneticEncoder.isMagnetTooWeak());
            telemetry.addData("Is Magnet Too Strong?", magneticEncoder.isMagnetTooStrong());
            telemetry.addData("Angle", "%.2f", magneticEncoder.getAngle());
            telemetry.addData("Raw Angle", "%d", magneticEncoder.getRawAngle());


//            telemetry.addData("Lower Limit", tempSensor.getTemperatureLimit(MCP9808.Register.T_LIMIT_LOWER));
//            telemetry.addData("Lower Limit Triggered", tempSensor.lowerLimitTriggered());
//            telemetry.addData("Upper Limit", tempSensor.getTemperatureLimit(MCP9808.Register.T_LIMIT_UPPER));
//            telemetry.addData("Upper Limit Triggered", tempSensor.upperLimitTriggered());
//            telemetry.addData("Critical Limit", tempSensor.getTemperatureLimit(MCP9808.Register.T_LIMIT_CRITICAL));
//            telemetry.addData("Critical Limit Triggered", tempSensor.criticalLimitTriggered());
//            telemetry.addData("", "");

//            telemetry.addData("Config", Integer.toHexString(tempSensor.readShort(MCP9808.Register.CONFIGURATION)));
//            telemetry.addData("Manufacturer ID", tempSensor.getManufacturerIDRaw());

            telemetry.update();
            idle();
        }
    }
}