package BrahmaCode;
import robocode.*;


import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import java.awt.*;
//import java.awt.Color;

public class RoboBrahma extends Robot
{

	public void run() {
		setBodyColor(Color.red);
		setGunColor(Color.yellow);
		setRadarColor(Color.black);
		setBulletColor(Color.red);

		while(true) {
			ahead(150);
			turnLeft(30);
			turnGunRight(360);
			turnRight(10);
			ahead(35);
			turnGunRight(180);
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
		if(e.getEnergy() > 80){
		fire(3);
		}
		if(e.getEnergy() < 50 && e.getEnergy() > 31){
		fire(2);
		} else {
			fire(1);
		}
		
	}

	public void onHitByBullet(HitByBulletEvent e) {
		back(120);
		turnRight(65);
	}
	
	public void onHitWall(HitWallEvent e) {
		turnLeft(90);
		back(180);
	}
	
	public void onWin(WinEvent e) {
		turnRight(36000);
	}	
}
