package me.robrahma;
import robocode.*;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import robocode.Rules;
import robocode.Bullet;
import java.awt.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * RoBrahma - a robot by (your name here)
 */
public class RoBrahma extends Robot
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
		if (getGunHeat() == 0) {
	       Bullet bullet = fireBullet(Rules.MAX_BULLET_POWER);
	       if (bullet != null) {
	           double bulletVelocity = bullet.getVelocity();
	       }
	   }else{
			if(e.getEnergy() > 80){
				fire(3);
			}else if(e.getEnergy() < 50 && e.getEnergy() > 31){
				fire(2);
			} else {
				fire(1);
			}
		}
		
	}

	public void onHitByBullet(HitByBulletEvent e) {
		back(120);
		turnRight(65);
		ahead(100);
	}
	
	public void onHitWall(HitWallEvent e) {
		turnLeft(90);
		back(180);
		ahead(20);
	}
	
	public void onWin(WinEvent e) {
		turnRight(36000);
	}	
}
