package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CeilingFan {

	private static int currentSpeed;

	private static DIRECTION currentDirection;

	public static enum DIRECTION {

		CLOCKWISE("clockwise"), COUNTER_CLOCKWISE("counter-clockwise");

		public String label;

		private DIRECTION(String label) {

			this.label = label;

		}
	};

	public CeilingFan() {

		currentSpeed = 0;

		currentDirection = DIRECTION.CLOCKWISE;

	}

	public static void main(String args[]) throws IOException {

		CeilingFan ceilingFan = new CeilingFan();

		System.out.println("Current direction of the fan is " + currentDirection.label + " with speed " + currentSpeed);

		// read value entered by user from console and call pullCords() accordingly

		while (true) {

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			String settingChain = in.readLine();

			if (settingChain.equals("speed")) {

				ceilingFan.pullCords(true);

			} else if (settingChain.equals("direction")) {

				ceilingFan.pullCords(false);

			} else {

				System.out.println("invalid input");

			}
		}
	}

	// managing speed and direction of the ceiling fan

	private void pullCords(boolean SpeedCord) {

		// increases speed of fan by 1 when speed cord is pulled

		if (SpeedCord) {

			currentSpeed = currentSpeed == 3 ? 0 : ++currentSpeed;

			System.out.println("Current direction of the fan is " + currentDirection.label + " with speed " + currentSpeed);

		} else {  // reverses direction of fan if direction chord is pulled
			
			currentDirection = currentDirection.equals(DIRECTION.CLOCKWISE) ? DIRECTION.COUNTER_CLOCKWISE : DIRECTION.CLOCKWISE;
			
			System.out.println("Current direction of the fan is " + currentDirection.label + " with speed " + currentSpeed);

		}
	}
}