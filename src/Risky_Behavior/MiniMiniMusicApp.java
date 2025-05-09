import javax.sound.midi.*; // Import the midi package
import static javax.sound.midi.ShortMessage.*; // We're using a static import here so we can use the constants in the ShortMessage class

public class MiniMiniMusicApp {

    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play() {

        try {
            // Step 1 : Get a Sequencer and open it.
            Sequencer player = MidiSystem.getSequencer(); // Get a sequencer and open it so we can use it
            player.open(); // (A Sequencer doesn't come already open)

            // Step 2: Make a new Sequence
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            // Step 3: Get a new Track from the Sequence
            Track track = seq.createTrack();
            /*
             * Ask the Sequence for the Track. Remember, the Track lives in the Sequence,
             * and the MIDI data lives in the Track.
             */

            // Step 4: Fill the Track with MidiEvents and give the Sequence to the Sequencer
            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(NOTE_ON, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(msg1, 1);
            track.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(NOTE_OFF, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(msg2, 16);
            track.add(noteOff);

            // Give the Sequence to the Sequencer (like selecting the song to play)
            player.setSequence(seq);

            // start() the Sequencer (play the song)
            player.start();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}