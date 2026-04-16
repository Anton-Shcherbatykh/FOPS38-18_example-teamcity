package plaindoll;

import java.util.Random;

public class Welcomer{
	// Если хочешь больше веселья и информации про ДевОпс - приходи в мои каналы NotOps (telegram, YT, Boosty, Patreon)
	// https://t.me/notopsofficial
	
	private static final String[] HUNTER_REPLICS = {
		"The hunter must hunt, even in this dream.",
		"Welcome home, good hunter. What is it your desire?",
		"Farewell, good hunter. May you find your worth in the waking world.",
		"A hunter is a hunter, even in a dream.",
		"Fear the old blood, good hunter.",
		"The night is long, brave hunter.",
		"Beware, hunter. The beasts lurk in shadow.",
		"Dear hunter, have you found your worth?",
		"Majestic! A hunter is never alone.",
		"Away! Away! You plague-ridden hunter!"
	};
	
	private final Random random = new Random();
	
	public String sayWelcome() {
		return "Welcome home, good hunter. What is it your desire?";
	}
	
	public String sayFarewell() {
		return "Farewell, good hunter. May you find your worth in waking world.";
	}
	
	public String sayNeedGold(){
		return "Not enough gold";
	}
	
	public String saySome(){
		return "something in the way";
	}
	
	/**
	 * Возвращает произвольную реплику, содержащую слово "hunter"
	 * @return случайная реплика со словом hunter
	 */
	public String getHunterReply() {
		int index = random.nextInt(HUNTER_REPLICS.length);
		return HUNTER_REPLICS[index];
	}
}
