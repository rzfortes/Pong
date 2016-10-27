package Pong;

import java.applet.Applet;
import java.applet.AudioClip;

// For the gameover sound, (a/an) 8 bit sound from http://opengameart.org/content/3-ping-pong-sounds-8-bit-style is used. :)
// only the "sounds_ping_pong_8bit.zip" file was downloaded

public class Sound {
    public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("ball.wav"));
    public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("ping_pong_8bit_peeeeeep.wav"));
    public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("back.wav"));
}
