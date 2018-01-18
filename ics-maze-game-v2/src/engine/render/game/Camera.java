package engine.render.game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

// Responsible for rendering the user's perspective of the 3D environment
// Stores information for the view matrix used to calculate how entities are rendered
public class Camera {

   public static Vector3f pos;

    // Rotations of the camera in degrees (0 - 360 is a circle) along x, y, z axis
    public static float pitch = 0;
    public static float yaw = 0;
    public static float roll = 0;

    // Initializes camera position to (0, 30, 0)
    public void create() {
        pos = new Vector3f(0, 30, 0);
    }

    public static void update(Vector3f r) {
        // Mouse movement
        pitch -= Mouse.getDY() * 0.03f;
        yaw += Mouse.getDX() * 0.03f;

        // Keyboard movement
        if (Keyboard.isKeyDown(Keyboard.KEY_X)) {
            pos.y = 100f;
            if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
                pos.z -= Math.sin(Math.toRadians(90 - yaw));
                pos.x += Math.cos(Math.toRadians(90 - yaw));
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
                pos.z += Math.sin(Math.toRadians(90 - yaw));
                pos.x -= Math.cos(Math.toRadians(90 - yaw));
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
                pos.z += Math.sin(Math.toRadians(180 - yaw));
                pos.x -= Math.cos(Math.toRadians(180 - yaw));
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
                pos.z -= Math.sin(Math.toRadians(180 - yaw));
                pos.x += Math.cos(Math.toRadians(180 - yaw));
            }
        }
        else {
            pos.x = r.x;
            pos.z = r.z;
            pos.y = r.y +2.5f;
        }
}

    // Getters and setters

    public Vector3f getPos() {
        return pos;
    }

    public void setPos(Vector3f pos) {
        this.pos = pos;
    }

    public float getPitch() {
        return pitch;
    }

    public void changePitch(float dp) {
        this.pitch += dp;
    }

    public float getYaw() {
        return yaw;
    }

    public void changeYaw(float dy) {
        this.yaw += dy;
    }

    public float getRoll() {
        return roll;
    }

    public void setRoll(float dr) {
        this.roll += dr;
    }

}
